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

class SearchTitleFragment : Fragment() {

    private var viewModel: SearchTitleViewModel =
        ViewModelProvider(this).get(SearchTitleViewModel::class.java)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentSearchTitleBinding>(
            inflater,
            R.layout.fragment_search_title, container, false
        )

        return binding.root
    }
}