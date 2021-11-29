package mx.konfio.dogslover.core

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import mx.konfio.dogslover.core.data.DogsObject

class DogService {

    suspend fun getDogsRemote(): MutableList<DogsObject> {
        return withContext(Dispatchers.IO) {
            val response = RetrofitClient.retrofit().getDogs()
            response.body() ?: emptyList()
        }.toMutableList()
    }

}