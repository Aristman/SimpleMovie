package ru.marslab.samplemovie.shared.data.network.responces.base

import ru.marslab.samplemovie.shared.data.exceptions.ConvertException

internal interface Dto<out T> {
    fun convert(): T

    fun convertError(message: String): Nothing = throw ConvertException(message)
}

internal fun <T : Any> List<Dto<T?>>?.convert(): List<T> {
    return this?.mapNotNull { it.convert() } ?: emptyList()
}

internal fun <T : Any, R : Any> List<Dto<T?>>?.convert(converter: (T) -> R): List<R> {
    return this?.mapNotNull { it.convert()?.let(converter) } ?: emptyList()
}

internal fun <T, D : Dto<T>, R> D.convert(converter: (T) -> R): R = convert().let(converter)
