package config

import core.InternalServerException
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.jackson.*
import io.ktor.response.*

fun Application.plugins() {
    install(StatusPages) {
        exception<Exception> { cause ->
            when (cause) {
                is InternalServerException -> {
                    val response: String? = cause.message
                    call.respond(HttpStatusCode.InternalServerError, response!!)
                }
            }
        }
    }

    install(ContentNegotiation) {
        jackson()
    }
}