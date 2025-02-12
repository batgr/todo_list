package network

import io.ktor.client.*

interface HttpClientProvider {
    val client: HttpClient
}