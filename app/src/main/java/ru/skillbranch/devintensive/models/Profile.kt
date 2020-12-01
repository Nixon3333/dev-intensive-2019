package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils

/**
 * Created by Drygin Nikita on 30,Ноябрь,2020
 */
data class Profile(
    val firstName: String,
    val lastName: String,
    val about: String,
    val repository: String,
    val rating: Int = 0,
    val respect: Int = 0
) {

    val nickName: String = getNickName(firstName, lastName)
    val rank: String = "Junior Android Developer"
    fun toMap(): Map<String, Any> = mapOf(
        "nickName" to nickName,
        "rank" to rank,
        "firstName" to firstName,
        "lastName" to lastName,
        "about" to about,
        "repository" to repository,
        "rating" to rating,
        "respect" to respect
    )

    private fun getNickName(_firstName: String, _lastName: String): String {
        val fullName = "$_firstName $_lastName"
        return Utils.transliteration(fullName, "_")
    }

}