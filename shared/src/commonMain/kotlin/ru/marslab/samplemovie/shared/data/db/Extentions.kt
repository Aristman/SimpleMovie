package ru.marslab.samplemovie.shared.data.db

import ru.marslab.samplemovie.shared.domain.entity.Image

infix fun Image.toDb(separator: Char): String =
    "$title$separator$url"

infix fun String.spitToList(separator: Char): List<String> =
    this.split(separator)

infix fun String.toImage(separator: Char): Image {
    val imageList = split(separator)
    return Image(
        title = imageList.component1(),
        url = imageList.component2()
    )
}
