import io.ktor.server.engine.*
import io.ktor.server.netty.*
import config.plugins
import config.routing

fun main() {
    with(Dependencies()) {
        embeddedServer(Netty, port = 8080) {
            plugins()
            routing(this@with)
        }.start(wait = true)
    }
}