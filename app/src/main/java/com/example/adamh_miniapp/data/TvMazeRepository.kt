package com.example.adamh_miniapp.data

import com.example.adamh_miniapp.model.TvMazeShowResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TvMazeRepository @Inject constructor(
    private val api: TvMazeApi,
) {

    suspend fun getApiResponse(query: String): List<TvMazeShowResponse> = api.searchMovies(query)
}
