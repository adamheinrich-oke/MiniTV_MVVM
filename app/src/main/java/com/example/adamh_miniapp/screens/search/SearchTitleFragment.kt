package com.example.adamh_miniapp.screens.search

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.adamh_miniapp.R
import com.example.adamh_miniapp.model.TvMazeShowResponse
import com.example.adamh_miniapp.screens.App
import com.example.adamh_miniapp.screens.di.DaggerSearchTitleComponent
import com.example.adamh_miniapp.screens.search.adapter.OnItemClickListener
import com.example.adamh_miniapp.screens.search.adapter.TvMazeShowResponseAdapter
import com.example.adamh_miniapp.utils.daggerViewModels

class SearchTitleFragment : Fragment(R.layout.search_fragment),OnItemClickListener {

    val viewModel: SearchTitleViewModel by daggerViewModels { requireActivity() }
    private val adapter: TvMazeShowResponseAdapter = TvMazeShowResponseAdapter(this)
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

        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)

        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null && newText.length > 2)
                    viewModel.searchMovies(newText)
                else adapter.setMoviesList(emptyList())
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
        })
    }

    override fun onItemClick(movie: TvMazeShowResponse) {
        val action = SearchTitleFragmentDirections.actionSearchTitleFragmentToDetailsFragment(movie)
        findNavController().navigate(action)
    }
}