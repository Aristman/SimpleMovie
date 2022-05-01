package ru.marslab.samplemovie.shared.data.network.responces

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TrailerResponse(
    @SerialName("fullTitle")
    val fullTitle: String,
    @SerialName("imDbId")
    val imDbId: String,
    @SerialName("link")
    val link: String,
    @SerialName("linkEmbed")
    val linkEmbed: String,
    @SerialName("thumbnailUrl")
    val thumbnailUrl: String,
    @SerialName("title")
    val title: String,
    @SerialName("type")
    val type: String,
    @SerialName("uploadDate")
    val uploadDate: String?,
    @SerialName("videoDescription")
    val videoDescription: String,
    @SerialName("videoId")
    val videoId: String,
    @SerialName("videoTitle")
    val videoTitle: String,
    @SerialName("year")
    val year: String,
    @SerialName("errorMessage")
    val errorMessage: String
)
