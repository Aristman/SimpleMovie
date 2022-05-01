package ru.marslab.samplemovie.shared.data.network.responces.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PostersNetworkEntity(
    @SerialName("backdrops")
    val backdrops: List<PosterNetworkEntity>,
    @SerialName("errorMessage")
    val errorMessage: String?,
    @SerialName("fullTitle")
    val fullTitle: String?,
    @SerialName("imDbId")
    val imDbId: String?,
    @SerialName("posters")
    val posters: List<PosterNetworkEntity>,
    @SerialName("title")
    val title: String?,
    @SerialName("type")
    val type: String?,
    @SerialName("year")
    val year: String?
) {
    @Serializable
    data class PosterNetworkEntity(
        @SerialName("aspectRatio")
        val aspectRatio: Double,
        @SerialName("height")
        val height: Int,
        @SerialName("id")
        val id: String?,
        @SerialName("language")
        val language: String?,
        @SerialName("link")
        val link: String?,
        @SerialName("width")
        val width: Int
    )
}
