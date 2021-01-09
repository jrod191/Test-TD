package cl.jrod191.novaera.data.remote

import cl.jrod191.novaera.domain.TelefonoRepository
import cl.jrod191.novaera.domain.model.Telefono

class RemoteTelefonoRepository (

    private val telefonosApi: TelefonosApi
    ) : TelefonoRepository {

        override suspend fun getAll(): List<Telefono> {
            return telefonosApi.allProducts()
        }

    }
