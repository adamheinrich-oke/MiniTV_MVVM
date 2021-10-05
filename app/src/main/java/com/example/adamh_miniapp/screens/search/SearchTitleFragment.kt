package com.example.adamh_miniapp.screens.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.adamh_miniapp.R
import com.example.adamh_miniapp.databinding.FragmentSearchTitleBinding
import com.example.adamh_miniapp.screens.di.ViewModelFactory

class SearchTitleFragment : Fragment() {

    private var viewModel: SearchTitleViewModel? = null
    private lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = DataBindingUtil.inflate<FragmentSearchTitleBinding>(
            inflater,
            R.layout.fragment_search_title, container, false
        )
        viewModelFactory = ViewModelFactory(SearchTitleViewModel())
        viewModel = ViewModelProvider(this, viewModelFactory).get(SearchTitleViewModel::class.java)
        return binding.root
    }
}