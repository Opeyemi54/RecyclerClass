package com.hfad.recyclerclass.adapters

import android.graphics.Movie
import androidx.recyclerview.widget.DiffUtil
import com.hfad.recyclerclass.dataclass.MovieDataClass

class DiffUtill : DiffUtil.ItemCallback<MovieDataClass>() {
    override fun areContentsTheSame(oldItem: MovieDataClass, newItem: MovieDataClass)
            = (oldItem.id == newItem.id)

    override fun areItemsTheSame(oldItem: MovieDataClass, newItem: MovieDataClass) = (oldItem == newItem)


}