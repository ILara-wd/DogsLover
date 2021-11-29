package mx.konfio.dogslover.ui.repository

import android.content.Context
import mx.konfio.dogslover.core.DogService
import mx.konfio.dogslover.core.data.DogsObject
import mx.konfio.dogslover.data.db.AppDatabase
import mx.konfio.dogslover.data.dao.DogsDao
import mx.konfio.dogslover.data.entities.DogsEntity

class DogRepository (mContext: Context) {

    private val dogsDao: DogsDao = AppDatabase.getDatabase(mContext).dogsEntityDao()
    private val api = DogService()

    fun getAllDogsLocal() = dogsDao.getAllDogsLocal()

    suspend fun saveDogs(dogsEntity: DogsEntity) {
        dogsDao.saveDogs(dogsEntity = dogsEntity)
    }

    suspend fun saveAllDogs(dogsList: MutableList<DogsEntity>) {
        dogsDao.saveAllDogs(dogsList = dogsList)
    }

    suspend fun deleteAll() {
        dogsDao.deleteAll()
    }

    suspend fun getAllDogsRemote(): MutableList<DogsObject> {
        val response = api.getDogsRemote()
        DogsProvider.quotes = response
        return response
    }

}