package com.example.adamh_miniapp.screens.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.adamh_miniapp.data.TvMazeRepository
import com.example.adamh_miniapp.model.TvMazeShowResponse
import javax.inject.Inject

class SearchTitleViewModel @Inject constructor(
    private val api: TvMazeRepository,
) : ViewModel() {
    private val currentQuery = MutableLiveData<String>()
    private val _moviesLiveData = MutableLiveData<List<TvMazeShowResponse>>()
    val moviesLiveData = _moviesLiveData as LiveData<List<TvMazeShowResponse>>

    suspend fun searchMovies(query: String) {
        currentQuery.value = query
        val response = currentQuery.value?.let {
            api.getApiResponse(it)
        }
        _moviesLiveData.postValue(response)
    }
}
