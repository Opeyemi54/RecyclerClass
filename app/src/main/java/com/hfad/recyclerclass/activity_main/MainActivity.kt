package com.hfad.recyclerclass.activity_main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hfad.recyclerclass.R
import com.hfad.recyclerclass.adapters.MovieAdapter
import com.hfad.recyclerclass.databinding.ActivityMainBinding
import com.hfad.recyclerclass.dataclass.MovieDataBase
import com.hfad.recyclerclass.repository.Repository
import com.hfad.recyclerclass.viewmodels.ViewModelFactory
import com.hfad.recyclerclass.viewmodels.ViewModels

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ViewModels
    private lateinit var adapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val repository = Repository(MovieDataBase.getInstance(this))
        viewModel = ViewModelProvider(this, ViewModelFactory(repository))[ViewModels::class.java]


        adapter = MovieAdapter(this@MainActivity)
        binding.recyclerAdapter.adapter = adapter

        viewModel.getEveryQuote.observe(this, Observer {
            movie ->
            adapter.submitList(movie)
        })


    }
}