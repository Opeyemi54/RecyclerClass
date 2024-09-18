package com.hfad.recyclerclass.dataclass

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DAO {
    @Insert
    suspend fun insert(quote: List<MovieDataClass>)


    @Query("SELECT * FROM movie_table ORDER BY  id DESC")
    fun getAll(): LiveData<List<MovieDataClass>>
}