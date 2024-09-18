package com.hfad.recyclerclass.repository

import androidx.lifecycle.LiveData
import com.hfad.recyclerclass.dataclass.MovieDataBase
import com.hfad.recyclerclass.dataclass.MovieDataClass

class Repository(private var db:MovieDataBase) {
    fun allMovies(): LiveData<List<MovieDataClass>> = db.dao().getAll()

}