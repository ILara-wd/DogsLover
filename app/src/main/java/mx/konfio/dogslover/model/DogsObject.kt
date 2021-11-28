package mx.konfio.dogslover.model

import com.google.gson.annotations.SerializedName

data class DogsObject(
    @SerializedName("dogName")
    val breedName: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("age")
    val id: Int,
    @SerializedName("url")
    val image: String
)