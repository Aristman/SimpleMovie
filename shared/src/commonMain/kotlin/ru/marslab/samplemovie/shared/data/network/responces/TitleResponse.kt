package ru.marslab.samplemovie.shared.data.network.responces

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.marslab.samplemovie.shared.data.exceptions.ServerException
import ru.marslab.samplemovie.shared.data.network.responces.base.Dto
import ru.marslab.samplemovie.shared.data.network.responces.base.convert
import ru.marslab.samplemovie.shared.data.network.responces.entity.ActorNetworkEntity
import ru.marslab.samplemovie.shared.data.network.responces.entity.BoxOfficeNetworkEntity
import ru.marslab.samplemovie.shared.data.network.responces.entity.CompanyNetworkEntity
import ru.marslab.samplemovie.shared.data.network.responces.entity.KeyValueNetworkEntity
import ru.marslab.samplemovie.shared.data.network.responces.entity.PostersNetworkEntity
import ru.marslab.samplemovie.shared.data.network.responces.entity.SimilarNetworkEntity
import ru.marslab.samplemovie.shared.data.network.responces.entity.StarNetworkEntity
import ru.marslab.samplemovie.shared.domain.entity.Movie

@Serializable
data class TitleResponse(
    @SerialName("actorList")
    val actorList: List<ActorNetworkEntity>,
    @SerialName("awards")
    val awards: String,
    @SerialName("boxOffice")
    val boxOffice: BoxOfficeNetworkEntity,
    @SerialName("companies")
    val companies: String,
    @SerialName("companyList")
    val companyList: List<CompanyNetworkEntity>,
    @SerialName("contentRating")
    val contentRating: String,
    @SerialName("countries")
    val countries: String,
    @SerialName("countryList")
    val countryList: List<KeyValueNetworkEntity>,
    @SerialName("directorList")
    val directorList: List<StarNetworkEntity>,
    @SerialName("directors")
    val directors: String,
    @SerialName("fullCast")
    val fullCast: FullCastResponse?,
    @SerialName("fullTitle")
    val fullTitle: String,
    @SerialName("genreList")
    val keyValueList: List<KeyValueNetworkEntity>,
    @SerialName("genres")
    val genres: String,
    @SerialName("id")
    val id: String,
    @SerialName("imDbRating")
    val imDbRating: String,
    @SerialName("imDbRatingVotes")
    val imDbRatingVotes: String,
    @SerialName("image")
    val image: String,
    @SerialName("images")
    val images: ImagesResponse?,
    @SerialName("keywordList")
    val keywordList: List<String>,
    @SerialName("keywords")
    val keywords: String,
    @SerialName("languageList")
    val languageList: List<KeyValueNetworkEntity>,
    @SerialName("languages")
    val languages: String,
    @SerialName("metacriticRating")
    val metacriticRating: String,
    @SerialName("originalTitle")
    val originalTitle: String,
    @SerialName("plot")
    val plot: String,
    @SerialName("plotLocal")
    val plotLocal: String,
    @SerialName("plotLocalIsRtl")
    val plotLocalIsRtl: Boolean,
    @SerialName("posters")
    val posters: PostersNetworkEntity?,
    @SerialName("ratings")
    val ratings: RatingsResponse?,
    @SerialName("releaseDate")
    val releaseDate: String,
    @SerialName("runtimeMins")
    val runtimeMins: String,
    @SerialName("runtimeStr")
    val runtimeStr: String,
    @SerialName("similars")
    val similars: List<SimilarNetworkEntity>,
    @SerialName("starList")
    val starList: List<StarNetworkEntity>,
    @SerialName("stars")
    val stars: String,
    @SerialName("title")
    val title: String,
    @SerialName("trailer")
    val trailer: TrailerResponse?,
    @SerialName("type")
    val type: String,
    @SerialName("writerList")
    val writerList: List<StarNetworkEntity>,
    @SerialName("writers")
    val writers: String,
    @SerialName("year")
    val year: String,
    @SerialName("errorMessage")
    val errorMessage: String?
) : Dto<Movie> {
    override fun convert(): Movie {
        if (!errorMessage.isNullOrBlank()) throw ServerException(errorMessage)
        return Movie(
            id = id,
            title = title,
            description = plotLocal.ifEmpty { plot },
            rating = imDbRating,
            image = image,
            images = images?.items?.convert() ?: emptyList(),
            year = year,
            release = releaseDate,
            runtime = runtimeStr,
            poster = posters?.posters?.first()?.link.orEmpty(),
            genres = genres
        )
    }
}
