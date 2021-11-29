package mx.konfio.dogslover.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import mx.konfio.dogslover.core.data.DogsObject

@Entity(tableName = "Dogs")
class DogsEntity(
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
) {
    constructor(dogsObject: DogsObject) : this(
        id = 0,
        dogName = dogsObject.dogName,
        description = dogsObject.description,
        age = dogsObject.age,
        url = dogsObject.url
    )
}