package ru.skillbranch.devintensive.extension

import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs

/**
 * Created by Drygin Nikita on 22,Ноябрь,2020
 */

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, timeUnit: TimeUnits = TimeUnits.SECOND): Date {
    var time = this.time
    time += when (timeUnit) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}

fun Date.humanizeDiff(date: Date = Date()): String {
    val diff = (date.time - this.time)
    val diffInt: Int = abs(diff.toInt())
    val isPositive = diff > 0
    return when (val diffToString = abs(diff)) {
        in 0L..1L * SECOND -> "только что"
        in 1L * SECOND..45L * SECOND -> "несколько секунд назад"
        in 45L * SECOND..75L * SECOND -> "минуту назад"
        in 75L * SECOND..45 * MINUTE ->
            if (!isPositive) "через ${diffToString / MINUTE} ${TimeUnits.MINUTE.plural((diffInt / MINUTE).toInt())}"
            else "${diffToString / MINUTE} ${TimeUnits.MINUTE.plural((diffInt / MINUTE).toInt())} назад"
        in 45 * MINUTE..75 * MINUTE -> "час назад"
        in 75 * MINUTE..22 * HOUR ->
            if (!isPositive) "через ${diffToString / HOUR} ${TimeUnits.HOUR.plural((diffInt / HOUR).toInt())}"
            else "${diffToString / HOUR} ${TimeUnits.HOUR.plural((diffInt / HOUR).toInt())} назад"
        in 22 * HOUR..26 * HOUR ->
            if (!isPositive) "через ${diffToString / HOUR} ${TimeUnits.HOUR.plural((diffInt / HOUR).toInt())}"
            else "${diffToString / HOUR} ${TimeUnits.HOUR.plural((diffInt / HOUR).toInt())} назад"
        in 26 * HOUR..360 * DAY -> if (!isPositive) "через ${diffToString / DAY} ${TimeUnits.DAY.plural((diffInt / DAY).toInt())}"
        else "${diffToString / DAY} ${TimeUnits.DAY.plural((diffInt / DAY).toInt())} назад"
        else -> if (!isPositive) "более чем через год" else "более года назад"
    }
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY
}
