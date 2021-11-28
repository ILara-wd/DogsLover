package mx.konfio.dogslover.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Dogs")
open class DogsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "dogName")
    val dogName: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "age")
    val age: Int,
    @ColumnInfo(name = "url")
    val url: String
)