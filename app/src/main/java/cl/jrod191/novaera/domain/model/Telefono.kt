package cl.jrod191.novaera.domain.model

import com.google.gson.annotations.SerializedName

class Telefono (
    @SerializedName("id") val id: Int,
    @SerializedName("image") val image: String,
    @SerializedName("name")val name: String,
    @SerializedName("price")val price: Int

)