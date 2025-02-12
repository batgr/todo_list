package network

import serialization.LocalDateTimeSerializer
import serialization.SimpleDateTimeSerializer
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.contextual

object DefaultHttpClientProvider : HttpClientProvider {
    override val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(
                Json{
                    serializersModule = SerializersModule {
                        contextual(LocalDateTimeSerializer)
                        contextual(SimpleDateTimeSerializer)
                    }
                }
            )
        }
    }
}