package com.example.adamh_miniapp.screens.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adamh_miniapp.data.TvMazeRepository
import com.example.adamh_miniapp.model.TvMazeShowResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchTitleViewModel @Inject constructor(
    private val api: TvMazeRepository,
) : ViewModel() {

    private val _moviesStateFlow = MutableStateFlow<List<TvMazeShowResponse>>(emptyList())
    val moviesStateFlow = _moviesStateFlow as StateFlow<List<TvMazeShowResponse>>

    fun searchMovies(query: String) {
        viewModelScope.launch {
            val response = api.getApiResponse(query)
            _moviesStateFlow.emit(response)
        }
    }
}
