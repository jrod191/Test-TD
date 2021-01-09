package cl.jrod191.novaera.ui

import androidx.recyclerview.widget.RecyclerView
import cl.jrod191.novaera.databinding.ItemTelefonoBinding
import cl.jrod191.novaera.domain.model.Telefono
import com.squareup.picasso.Picasso

class TelefonoViewHolder(
    private val binding: ItemTelefonoBinding,
    private val onItemClickTelefono:TelefonosFragment
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(telefono: Telefono) {
        binding.apply {
            tvNombre.text = telefono.name
            Picasso.get().load(telefono.image).into(ivProducto)
            tvValor.text = telefono.price.toString()
        }
        onItemClickTelefono.onItemCLickProducto(telefono)
    }
}
