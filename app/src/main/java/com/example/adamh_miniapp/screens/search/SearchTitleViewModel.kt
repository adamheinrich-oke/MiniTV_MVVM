package com.example.adamh_miniapp.screens.search

import android.util.Log
import androidx.lifecycle.ViewModel

class SearchTitleViewModel : ViewModel() {

    init {
        Log.i("SearchTitleViewModel", "ViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("SearchTitleViewModel", "ViewModel destroyed!")
    }
}