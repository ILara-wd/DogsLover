package mx.konfio.dogslover.core.data

import com.google.gson.annotations.SerializedName

class DogsObject(
    @SerializedName("dogName")
    val dogName: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("age")
    val age: Int,
    @SerializedName("url")
    val url: String
)