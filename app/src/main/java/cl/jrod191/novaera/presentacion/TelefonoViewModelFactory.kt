package cl.jrod191.novaera.presentacion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cl.jrod191.novaera.domain.ObtenerTelefonoUseCase

class TelefonoViewModelFactory (
    private val obtenerProductosUseCase: ObtenerTelefonoUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ObtenerTelefonoUseCase::class.java)
            .newInstance(obtenerProductosUseCase)
    }


}