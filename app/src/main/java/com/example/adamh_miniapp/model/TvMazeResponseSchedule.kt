package com.example.adamh_miniapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TvMazeResponseSchedule(
    @SerializedName("time") val time: String?,
    @SerializedName("days") val days: List<String>?,
) : Serializable
