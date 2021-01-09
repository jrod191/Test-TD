package cl.jrod191.novaera.domain

import cl.jrod191.novaera.domain.model.Telefono

interface TelefonoRepository {
    suspend fun getAll() : List<Telefono>
}