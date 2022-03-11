package routes

import controllers.MainController
import data.Participant
import data.Promotion
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.mainRouting(mainController: MainController) {
    get("/promo") {
        call.respond(mainController.getPromo())
    }

    post("/promo") {
        val promotion = call.receive<Promotion>()
        mainController.postPromo(promotion)
        call.respondText("Promotion added", status = HttpStatusCode.Created)
    }

    get("/promo/{id}") {
        val promoId = call.parameters["id"]
        call.respond(mainController.getPromoById(promoId))
    }

    put("/promo/{id}") {
        val promoId = call.parameters["id"]
        val promotion = call.receive<Promotion>()
        mainController.putPromo(promoId, promotion)
        call.respondText("Promotion added", status = HttpStatusCode.Created)
    }

    delete("/promo/{id}") {
        val promoId = call.parameters["id"]
        call.respond(mainController.deletePromoById(promoId))
    }

    post("/promo/{id}/participant") {
        val promoId = call.parameters["id"]
        val participant = call.receive<Participant>()
        mainController.addParticipantToPromo(promoId, participant)
        call.respondText("Participant added", status = HttpStatusCode.Created)
    }
}