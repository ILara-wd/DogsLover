package mx.konfio.dogslover.core

import mx.konfio.dogslover.core.data.DogsObject
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {
    @GET("api/914615664132767744")
    suspend fun getDogs(): Response<MutableList<DogsObject>>
}