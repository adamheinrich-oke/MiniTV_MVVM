package com.example.adamh_miniapp.screens.search

import androidx.lifecycle.ViewModel
import com.example.adamh_miniapp.data.TvMazeRepository
import com.example.adamh_miniapp.model.TvMazeShowResponse
import javax.inject.Inject

class SearchTitleViewModel @Inject constructor(
    private val api: TvMazeRepository,
) : ViewModel() {

    suspend fun testApi(query: String): List<TvMazeShowResponse> = api.getApiResponse(query)
}
