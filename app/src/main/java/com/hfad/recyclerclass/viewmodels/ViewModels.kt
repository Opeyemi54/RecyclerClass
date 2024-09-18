package com.hfad.recyclerclass.viewmodels

import androidx.lifecycle.ViewModel
import com.hfad.recyclerclass.repository.Repository

class ViewModels(private var repository: Repository) : ViewModel() {
    val getEveryQuote = repository.allMovies()
}