package mx.konfio.dogslover.ui.repository

import android.content.Context
import androidx.lifecycle.LiveData
import mx.konfio.dogslover.data.AppDatabase
import mx.konfio.dogslover.data.dao.DogsDao
import mx.konfio.dogslover.data.entities.DogsEntity

class DogRepository(mContext: Context) {

    private val dogsDao: DogsDao = AppDatabase.getDatabase(mContext).dogsEntityDao()
    
    suspend fun getAllDogsLocal() = dogsDao.getAllDogsLocal()

    suspend fun saveDogs(dogsEntity: DogsEntity) {
        dogsDao.saveDogs(dogsEntity = dogsEntity)
    }

    suspend fun deleteAll() {
        dogsDao.deleteAll()
    }

}