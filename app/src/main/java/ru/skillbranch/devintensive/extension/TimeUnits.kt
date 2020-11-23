package ru.skillbranch.devintensive.extension

/**
 * Created by Drygin Nikita on 22,Ноябрь,2020
 */

fun TimeUnits.plural(value: Int): String {
    return when (value) {
        1 -> when (this) {
            TimeUnits.SECOND -> "секунда"
            TimeUnits.MINUTE -> "минута"
            TimeUnits.HOUR -> "час"
            TimeUnits.DAY -> "день"
        }
        in 2..4 -> when (this) {
            TimeUnits.SECOND -> "секунды"
            TimeUnits.MINUTE -> "минуты"
            TimeUnits.HOUR -> "часа"
            TimeUnits.DAY -> "дня"
        }
        else -> when (this) {
            TimeUnits.SECOND -> "секунд"
            TimeUnits.MINUTE -> "минут"
            TimeUnits.HOUR -> "часов"
            TimeUnits.DAY -> "дней"
        }
    }
}