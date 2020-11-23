package ru.skillbranch.devintensive.extension

/**
 * Created by Drygin Nikita on 22,Ноябрь,2020
 */

fun String.truncate(value: Int = 16): String {
    return if (this.trim().length < value) this else "${this.substring(0, value).trim()}..."
}

fun String.stripHtml(): String {
    return (this.replace("<[^>]*>".toRegex(), "")).replace("[ ]{2,}".toRegex(), " ")
}