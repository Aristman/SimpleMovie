package ru.marslab.samplemovie.shared.data.network.responces.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SimilarNetworkEntity(
    @SerialName("id")
    val id: String?,
    @SerialName("imDbRating")
    val imDbRating: String?,
    @SerialName("image")
    val image: String?,
    @SerialName("title")
    val title: String?
)
