package com.example.adamh_miniapp.screens.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.adamh_miniapp.data.TvMazeRepository
import com.example.adamh_miniapp.model.TvMazeShowResponse
import javax.inject.Inject

class SearchTitleViewModel @Inject constructor(
    private val api: TvMazeRepository,
) : ViewModel() {
    private val currentQuery = MutableLiveData("star wars")
    var movies = MutableLiveData<List<TvMazeShowResponse>>()

    suspend fun searchMovies(): MutableLiveData<List<TvMazeShowResponse>> {
        val response = api.getApiResponse(currentQuery.value!!)
        movies.postValue(response)
        return movies
    }

    suspend fun searchPhotos(query: String) {
        currentQuery.value = query
    }
}
