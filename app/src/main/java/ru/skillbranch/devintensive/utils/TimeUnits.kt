package ru.skillbranch.devintensive.utils

import kotlin.math.absoluteValue

enum class TimeUnits(val size: Long) {
    SECOND(1000L),
    MINUTE(60 * SECOND.size),
    HOUR(60 * MINUTE.size),
    DAY(24 * HOUR.size);

    fun plural(value: Long) = "$value ${pluralStrings[value.asPlurals]}"
}

val /*ru.skillbranch.devintensive.extensions.TimeUnits.*/pluralStrings
    get() = when (TimeUnits.values()) {
        TimeUnits.SECOND -> mapOf(Plurals.ONE to "секунду", Plurals.FEW to "секунды", Plurals.MANY to "секунд")
        TimeUnits.MINUTE -> mapOf(Plurals.ONE to "минуту", Plurals.FEW to "минуты", Plurals.MANY to "минут")
        TimeUnits.HOUR -> mapOf(Plurals.ONE to "час", Plurals.FEW to "часа", Plurals.MANY to "часов")
        TimeUnits.DAY -> mapOf(Plurals.ONE to "день", Plurals.FEW to "дня", Plurals.MANY to "дней")
        else -> mapOf()
    }

val Int.sec get() = this * TimeUnits.SECOND.size
val Int.min get() = this * TimeUnits.MINUTE.size
val Int.hour get() = this * TimeUnits.HOUR.size
val Int.day get() = this * TimeUnits.DAY.size

val Long.asMin get() = this.absoluteValue / TimeUnits.MINUTE.size
val Long.asHour get() = this.absoluteValue / TimeUnits.HOUR.size
val Long.asDay get() = this.absoluteValue / TimeUnits.DAY.size
