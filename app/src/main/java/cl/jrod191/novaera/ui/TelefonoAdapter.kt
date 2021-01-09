package cl.jrod191.novaera.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.jrod191.novaera.databinding.ItemTelefonoBinding
import cl.jrod191.novaera.domain.model.Telefono

class TelefonoAdapter(
    private val telefono: List<Telefono>,
    private val itemClickTelefono: TelefonosFragment
) : RecyclerView.Adapter<TelefonoViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TelefonoViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val binding = ItemTelefonoBinding.inflate(inflate,parent, false)
        return TelefonoViewHolder(binding, itemClickTelefono)
    }

    override fun onBindViewHolder(holder: TelefonoViewHolder, position: Int) {
        holder.bind(telefono[position])
    }

    override fun getItemCount() = telefono.size

}