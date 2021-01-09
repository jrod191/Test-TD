package cl.jrod191.novaera.presentacion

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.jrod191.novaera.domain.ObtenerTelefonoUseCase
import cl.jrod191.novaera.domain.model.Telefono
import kotlinx.coroutines.launch
import java.lang.Exception

class TelefonoViewModel (private val obtenerProductosUseCase: ObtenerTelefonoUseCase
) : ViewModel(){

    private val liveData = MutableLiveData<TelefonoUiState>()

    fun getLiveData() = liveData

    fun obtenerProductos(){
        liveData.postValue(TelefonoUiState.LoadingTelefonoUiState)
        viewModelScope.launch {
            try {
                val result = obtenerProductosUseCase.execute()
                handleResult(result)
            }catch (e: Exception){
                handleError(e)
            }
        }
    }

    private fun handleError(e: Exception) {
        liveData.postValue(TelefonoUiState.ErrorServerTelefonoUiState)
    }

    private fun handleResult(result: List<Telefono>) {
        if(result.isEmpty()){
            liveData.postValue(TelefonoUiState.EmptyListTelefonoUiState)
        }else{
            liveData.postValue(TelefonoUiState.Success(result))
        }
    }
}
