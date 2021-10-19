package com.example.adamh_miniapp.screens.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.example.adamh_miniapp.R
import com.example.adamh_miniapp.screens.App
import com.example.adamh_miniapp.screens.di.DaggerSearchTitleComponent
import com.example.adamh_miniapp.utils.daggerViewModels
import kotlinx.coroutines.launch

class SearchTitleFragment : Fragment(R.layout.search_fragment) {

    val viewModel: SearchTitleViewModel by daggerViewModels { requireActivity() }
    private val adapter = TvMazeShowResponseAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DaggerSearchTitleComponent
            .builder()
            .appComponent((requireActivity().application as App).getAppComponent())
            .build()
            .inject(this)

        val recycleView = requireView().findViewById(R.id.recycler_view) as RecyclerView
        recycleView.setHasFixedSize(true)
        recycleView.adapter = adapter
        viewModel.movies.observe(viewLifecycleOwner, Observer
        {

            adapter.setMovieList(it)
        })

        viewModel.viewModelScope.launch { viewModel.searchMovies() }
    }
}
