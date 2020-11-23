package ru.skillbranch.devintensive.models

/**
 * Created by Drygin Nikita on 22,Ноябрь,2020
 */
class Chat(
    val id: String,
    val members: MutableList<User> = mutableListOf(),
    val messages: MutableList<BaseMessage> = mutableListOf()
) {
}