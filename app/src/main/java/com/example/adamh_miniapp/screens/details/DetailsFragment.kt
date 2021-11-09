package com.example.adamh_miniapp.screens.details

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.adamh_miniapp.R

class DetailsFragment : Fragment(R.layout.details_fragment) {

    private val args by navArgs<DetailsFragmentArgs>()
    private lateinit var image: AppCompatImageView
    private lateinit var title: TextView
    private lateinit var showPlaytime: TextView
    private lateinit var summary: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        image = view.findViewById(R.id.MoviePosterImageView)
        title = view.findViewById(R.id.MovieTitleTextView)
        showPlaytime = view.findViewById(R.id.PlayTimeTextView)
        summary = view.findViewById(R.id.SummaryTextView)

        title.text = args.movie.show.name
        showPlaytime.text =
            "${args.movie.show.schedule?.time}  ${args.movie.show.schedule?.days?.joinToString()}"
        summary.text =
            args.movie.show.summary?.let {
                HtmlCompat.fromHtml(
                    it,
                    HtmlCompat.FROM_HTML_MODE_LEGACY
                )
            }
        Glide.with(this@DetailsFragment)
            .load(args.movie.show.imageUrls?.original)
            .into(image)
    }
}