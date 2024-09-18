package com.hfad.recyclerclass.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hfad.recyclerclass.repository.Repository

class ViewModelFactory(private val repository: Repository)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModels::class.java)) {
            return ViewModels(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}