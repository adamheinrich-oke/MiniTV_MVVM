package com.example.adamh_miniapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TvMazeResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String?,
    @SerializedName("genres") val genres: List<String>?,
    @SerializedName("summary") val summary: String?,
    @SerializedName("schedule") val schedule: TvMazeResponseSchedule?,
    @SerializedName("image") val imageUrls: TvMazeResponseImageUrls?,
) : Serializable