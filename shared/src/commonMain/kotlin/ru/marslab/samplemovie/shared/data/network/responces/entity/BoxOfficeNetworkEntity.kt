package ru.marslab.samplemovie.shared.data.network.responces.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BoxOfficeNetworkEntity(
    @SerialName("budget")
    val budget: String?,
    @SerialName("cumulativeWorldwideGross")
    val cumulativeWorldwideGross: String?,
    @SerialName("grossUSA")
    val grossUSA: String?,
    @SerialName("openingWeekendUSA")
    val openingWeekendUSA: String?
)
