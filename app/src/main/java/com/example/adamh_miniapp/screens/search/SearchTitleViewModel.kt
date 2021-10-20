package com.example.adamh_miniapp.screens.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adamh_miniapp.data.TvMazeRepository
import com.example.adamh_miniapp.model.TvMazeShowResponse
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchTitleViewModel @Inject constructor(
    private val api: TvMazeRepository,
) : ViewModel() {

    private val _moviesLiveData = MutableLiveData<List<TvMazeShowResponse>>()
    val moviesLiveData = _moviesLiveData as LiveData<List<TvMazeShowResponse>>

    fun searchMovies(query: String) {
        viewModelScope.launch {
            val response = api.getApiResponse(query)
            _moviesLiveData.postValue(response)
        }
    }
}
