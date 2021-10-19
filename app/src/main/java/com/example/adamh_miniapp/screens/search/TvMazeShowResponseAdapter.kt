package com.example.adamh_miniapp.screens.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.adamh_miniapp.R
import com.example.adamh_miniapp.model.TvMazeShowResponse

class TvMazeShowResponseAdapter : RecyclerView.Adapter<TvMazeShowResponseViewHolder>() {

    var movies = mutableListOf<TvMazeShowResponse>()

    fun setMovieList(movies: List<TvMazeShowResponse>) {
        this.movies = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TvMazeShowResponseViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tvmaze, parent, false)
        return TvMazeShowResponseViewHolder(view)
    }

    override fun onBindViewHolder(holder: TvMazeShowResponseViewHolder, position: Int) {
        val movie = movies[position]
        holder.movieTitle.text = movie.show.name
        holder.movieGenre.text = movie.show.genres.toString()
        Glide.with(holder.itemView.context).load(movie.show.imageUrls?.medium)
            .into(holder.moviePoster)

    }

    override fun getItemCount(): Int {
        return movies.size
    }
}

class TvMazeShowResponseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val movieTitle = itemView.findViewById(R.id.MovieTitleTextView) as TextView
    val movieGenre = itemView.findViewById(R.id.MovieGenreTextView) as TextView
    val moviePoster = itemView.findViewById(R.id.MoviePosterImageView) as ImageView
}