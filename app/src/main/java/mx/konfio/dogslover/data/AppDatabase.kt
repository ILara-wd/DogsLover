package mx.konfio.dogslover.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import mx.konfio.dogslover.data.dao.DogsDao
import mx.konfio.dogslover.data.entities.DogsEntity

@Database(
    entities = [DogsEntity::class],
    version = 1, exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun dogsEntityDao(): DogsDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            INSTANCE = INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "dogs_bd"
            )
                .allowMainThreadQueries()
                .build()
            return INSTANCE!!
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }

}