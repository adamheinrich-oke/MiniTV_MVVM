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
import com.example.adamh_miniapp.screens.App
import com.example.adamh_miniapp.screens.di.DaggerSearchTitleComponent
import com.example.adamh_miniapp.screens.di.ViewModelFactory
import javax.inject.Inject

class SearchTitleFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        DaggerSearchTitleComponent
            .builder()
            .appComponent((requireActivity().application as App).getAppComponent())
            .build()
            .inject(this)


        val binding = DataBindingUtil.inflate<FragmentSearchTitleBinding>(
            inflater,
            R.layout.fragment_search_title, container, false
        )
        val viewmodel = ViewModelProvider(this, viewModelFactory)[SearchTitleViewModel::class.java]
        return binding.root
    }
}