package com.example.adamh_miniapp.screens.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.adamh_miniapp.R
import com.example.adamh_miniapp.screens.App
import com.example.adamh_miniapp.screens.di.DaggerSearchTitleComponent
import com.example.adamh_miniapp.screens.search.adapter.TvMazeShowResponseAdapter
import com.example.adamh_miniapp.utils.daggerViewModels

class SearchTitleFragment : Fragment(R.layout.search_fragment) {

    val viewModel: SearchTitleViewModel by daggerViewModels { requireActivity() }
    private val adapter: TvMazeShowResponseAdapter = TvMazeShowResponseAdapter()
    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DaggerSearchTitleComponent
            .builder()
            .appComponent((requireActivity().application as App).getAppComponent())
            .build()
            .inject(this)

        recyclerView = requireView().findViewById(R.id.recycler_view)
        recyclerView.apply {
            setHasFixedSize(true)
            adapter = this@SearchTitleFragment.adapter
        }

        viewModel.moviesLiveData.observe(viewLifecycleOwner) {
            adapter.setMoviesList(it)
        }

        viewModel.searchMovies("star wars")
    }
}