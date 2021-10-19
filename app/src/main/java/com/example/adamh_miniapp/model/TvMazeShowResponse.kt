package com.example.adamh_miniapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TvMazeShowResponse(
    @SerializedName("show") val show: TvMazeResponse
) : Serializable
