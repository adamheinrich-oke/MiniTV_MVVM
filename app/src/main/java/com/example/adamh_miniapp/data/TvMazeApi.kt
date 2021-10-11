package com.example.adamh_miniapp.data

import com.example.adamh_miniapp.model.TvMazeShowResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TvMazeApi {

    companion object {
        const val BASE_URL = "https://api.tvmaze.com/"
    }

    @GET("search/shows")
    suspend fun searchMovies(
        @Query("q") query: String
    ): List<TvMazeShowResponse>
}