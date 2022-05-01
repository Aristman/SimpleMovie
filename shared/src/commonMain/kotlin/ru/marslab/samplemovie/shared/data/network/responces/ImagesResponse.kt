package ru.marslab.samplemovie.shared.data.network.responces

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.marslab.samplemovie.shared.data.network.responces.base.Dto
import ru.marslab.samplemovie.shared.domain.entity.Image

@Serializable
data class ImagesResponse(
    @SerialName("fullTitle")
    val fullTitle: String,
    @SerialName("imDbId")
    val imDbId: String,
    @SerialName("items")
    val items: List<ImageDataDetailNetworkEntity>,
    @SerialName("title")
    val title: String,
    @SerialName("type")
    val type: String,
    @SerialName("year")
    val year: String,
    @SerialName("errorMessage")
    val errorMessage: String?
) {
    @Serializable
    data class ImageDataDetailNetworkEntity(
        @SerialName("image")
        val image: String,
        @SerialName("title")
        val title: String
    ) : Dto<Image> {
        override fun convert(): Image =
            Image(title, image)
    }
}
