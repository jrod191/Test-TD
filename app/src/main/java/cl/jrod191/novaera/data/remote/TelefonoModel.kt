package cl.jrod191.novaera.data.remote

import com.google.gson.annotations.SerializedName

class TelefonoModel(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("price") val price: Int,
    @SerializedName("image") val image: String,


)