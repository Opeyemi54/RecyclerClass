package com.hfad.recyclerclass.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hfad.recyclerclass.R
import com.hfad.recyclerclass.dataclass.MovieDataClass

class MovieAdapter(private var context: Context)
    : ListAdapter<MovieDataClass, MovieAdapter.MyViewHolder>(DiffUtill()) {


    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val movieTitle:TextView = itemView.findViewById(R.id.movie_title)
        val img:ImageView = itemView.findViewById(R.id.movie_img1)
        val cardView:CardView = itemView.findViewById(R.id.cardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.MyViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.movie_list,parent,false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MovieAdapter.MyViewHolder, position: Int) {
        val currentPosition = getItem(position)
        holder.movieTitle.text = currentPosition.movieTitt
        holder.img.setImageResource(currentPosition.movieImg)
        holder.cardView.setOnClickListener{
            Toast.makeText(context, currentPosition.movieTitt, Toast.LENGTH_SHORT).show()
        }
    }
}