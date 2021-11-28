package mx.konfio.dogslover.core

import mx.konfio.dogslover.core.data.DogsObject
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {
    @GET("api/880188946124021760")
    suspend fun getDogs(): Response<List<DogsObject>>
}