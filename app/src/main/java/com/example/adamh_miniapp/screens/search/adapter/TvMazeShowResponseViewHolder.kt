package com.example.adamh_miniapp.screens.search.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.adamh_miniapp.R

class TvMazeShowResponseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val movieTitle = itemView.findViewById(R.id.MovieTitleTextView) as TextView
    val movieGenre = itemView.findViewById(R.id.MovieGenreTextView) as TextView
    val moviePoster = itemView.findViewById(R.id.MoviePosterImageView) as ImageView
}