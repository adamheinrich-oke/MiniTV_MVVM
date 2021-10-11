package com.example.adamh_miniapp.model

import java.io.Serializable

data class TvMazeResponse(
    val id: Int,
    val name: String?,
    val genres: List<String>?,
    val image: TvMazeResponseImageUrls?
) : Serializable