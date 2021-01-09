package cl.jrod191.novaera.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import cl.jrod191.novaera.R
import cl.jrod191.novaera.data.remote.RemoteTelefonoRepository
import cl.jrod191.novaera.data.remote.RetrofitHandler
import cl.jrod191.novaera.databinding.FragmentTelefonosBinding
import cl.jrod191.novaera.domain.ObtenerTelefonoUseCase
import cl.jrod191.novaera.domain.model.Telefono
import cl.jrod191.novaera.presentacion.TelefonoUiState
import cl.jrod191.novaera.presentacion.TelefonoViewModel
import cl.jrod191.novaera.presentacion.TelefonoViewModelFactory

class TelefonosFragment : Fragment(R.layout.fragment_telefonos) {

    private lateinit var viewModel: TelefonoViewModel
    private lateinit var viewModelFactory: TelefonoViewModelFactory
    private lateinit var binding: FragmentTelefonosBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDependencies()
        binding = FragmentTelefonosBinding.bind(view)
        setupRecyclerView()
        setupLiveData()

    }

    private fun setupDependencies() {
        viewModelFactory = TelefonoViewModelFactory(
            ObtenerTelefonoUseCase(
                RemoteTelefonoRepository(
                    RetrofitHandler.getTelefonoApi()
                )
            )
        )

        viewModel = ViewModelProvider(this, viewModelFactory).get(TelefonoViewModel::class.java)


    }

    private fun setupRecyclerView() {
        binding.apply {
            rvListadoTelefonos.setHasFixedSize(true)
            val layoutManager = LinearLayoutManager(context)
            rvListadoTelefonos.layoutManager = layoutManager
            rvListadoTelefonos.addItemDecoration(DividerItemDecoration(context, layoutManager.orientation))
        }
    }

    private fun setupLiveData() {
        viewModel.getLiveData().observe(
            viewLifecycleOwner,
            Observer {
                it?.let { safeState -> handleState(safeState) }
            }
        )
        viewModel.obtenerProductos()
    }

    private fun handleState(safeState: TelefonoUiState) {
        when (safeState) {
            is TelefonoUiState.LoadingTelefonoUiState -> showLoading()
            is TelefonoUiState.ErrorServerTelefonoUiState-> showErrorServer()
            is TelefonoUiState.Success -> loadResult(safeState.result)
            is TelefonoUiState.EmptyListTelefonoUiState -> showEmptyList()
        }
    }

    private fun showEmptyList() {
        Toast.makeText(context, "Empty List", Toast.LENGTH_SHORT).show()
    }

    private fun loadResult(telefono: List<Telefono>?) {
        telefono?.let { safeTelefono ->
            binding.rvListadoTelefonos.adapter = TelefonoAdapter(safeTelefono, this)
        }
    }

    private fun showErrorServer() {
        Toast.makeText(context, "No hay coneccion con el servidor", Toast.LENGTH_SHORT).show()
    }

    private fun showLoading() {
        Toast.makeText(context, "Cargando.....", Toast.LENGTH_SHORT).show()
    }

    fun onItemCLickProducto(telefono: Telefono) {

    }
}