package cl.jrod191.novaera.data.remote

import cl.jrod191.novaera.domain.model.Telefono
import retrofit2.http.GET


interface TelefonosApi {

    @GET("products/")
    suspend fun allProducts(): List<Telefono>
}
