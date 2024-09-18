package com.hfad.recyclerclass.dataclass

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "movie_table")
data class MovieDataClass(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0L,
    val movieTitt : String = "",
    val movieImg: Int = 0
) {
}