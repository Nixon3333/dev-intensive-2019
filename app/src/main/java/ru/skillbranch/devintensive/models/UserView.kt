package ru.skillbranch.devintensive.models

/**
 * Created by Drygin Nikita on 23,Ноябрь,2020
 */
class UserView(
    val id: String,
    val fullName: String,
    val nickName: String,
    var avatar: String? = null,
    var status: String? = "offline",
    var initials: String?
) {
}