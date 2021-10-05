package com.example.adamh_miniapp.screens.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.adamh_miniapp.screens.search.SearchTitleViewModel

class ViewModelFactory constructor(private val searchTitleViewModel: SearchTitleViewModel) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        if (modelClass == SearchTitleViewModel::class.java) {
            searchTitleViewModel as T
        } else {
            throw  IllegalStateException("Unknown entity")
        }
}