package com.example.adamh_miniapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TvMazeResponseImageUrls(
    @SerializedName("medium") val medium: String?,
    @SerializedName("original") val original: String?,
) : Serializable

