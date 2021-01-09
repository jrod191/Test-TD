package cl.jrod191.novaera.domain

class ObtenerTelefonoUseCase (

private val repository: TelefonoRepository
) {
    suspend fun execute() = repository.getAll()
}

