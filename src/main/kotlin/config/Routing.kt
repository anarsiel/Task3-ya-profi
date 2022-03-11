package config

import Dependencies
import io.ktor.application.*
import io.ktor.routing.*
import routes.mainRouting

fun Application.routing(dependencies: Dependencies) {
    routing {
        mainRouting(dependencies.mainController)
    }
}