package com.example.adamh_miniapp.screens.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.adamh_miniapp.R
import com.example.adamh_miniapp.screens.App
import com.example.adamh_miniapp.screens.di.DaggerSearchTitleComponent
import com.example.adamh_miniapp.utils.daggerViewModels

class SearchTitleFragment : Fragment(R.layout.search_fragment) {

    val viewModel: SearchTitleViewModel by daggerViewModels { requireActivity() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerSearchTitleComponent
            .builder()
            .appComponent((requireActivity().application as App).getAppComponent())
            .build()
            .inject(this)
    }

    suspend fun getData(query: String) {
        viewModel.testApi(query)
    }
}
