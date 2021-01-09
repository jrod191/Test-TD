package cl.jrod191.novaera.presentacion

import cl.jrod191.novaera.domain.model.Telefono

sealed class TelefonoUiState (open val result: List <Telefono>? = null){

    object LoadingTelefonoUiState: TelefonoUiState()
    object EmptyListTelefonoUiState: TelefonoUiState()
    data class Success (override val result: List<Telefono>): TelefonoUiState(result)
    object ErrorServerTelefonoUiState: TelefonoUiState()
}