package mx.konfio.dogslover.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mx.konfio.dogslover.data.entities.DogsEntity

@Dao
interface DogsDao {

    @Query("SELECT * FROM Dogs")
    fun getAllDogsLocal(): LiveData<MutableList<DogsEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveDogs(dogsEntity: DogsEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllDogs(dogsList: MutableList<DogsEntity>)

    @Query("DELETE FROM Dogs")
    suspend fun deleteAll()

    @Query("SELECT * FROM Dogs LIMIT 1")
    suspend fun getLastDog(): DogsEntity
}