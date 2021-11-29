package mx.konfio.dogslover.data.db

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import mx.konfio.dogslover.data.dao.DogsDao
import mx.konfio.dogslover.data.entities.DogsEntity
import org.hamcrest.CoreMatchers.isA
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class AppDatabaseTest : TestCase() {

    private lateinit var spendsDao: DogsDao
    private lateinit var db: AppDatabase

    @Before
    public override fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java
        ).build()
        spendsDao = db.dogsEntityDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    fun writeAndReadSpend() = runBlocking {
        val dog = DogsEntity(
            id = 1,
            dogName = "Pomeranian",
            description = "Descended from large sled dog breeds, the now-tiny Pomeranian has a long and interesting history.",
            age = 3,
            url = "https://www.petdarling.com/wp-content/uploads/2015/05/perro-pomerania.jpg"
        )
        spendsDao.saveDogs(dogsEntity = dog)
        val getLastDog = spendsDao.getLastDog()
        assertEquals(dog, getLastDog)
    }

}