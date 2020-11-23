package ru.skillbranch.devintensive.models

import java.util.*

/**
 * Created by Drygin Nikita on 22,Ноябрь,2020
 */
class ImageMessage(
    id: String,
    from: User?,
    chat: Chat,
    isIncoming: Boolean = false,
    date: Date = Date(),
    var image: String?
) : BaseMessage(id, from, chat, isIncoming, date) {
    override fun formatMessage(): String {
        TODO("Not yet implemented")
    }
}