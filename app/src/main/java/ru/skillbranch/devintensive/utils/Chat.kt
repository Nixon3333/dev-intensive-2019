package ru.skillbranch.devintensive.utils

import ru.skillbranch.devintensive.R
import ru.skillbranch.devintensive.extensions.shortFormat
import ru.skillbranch.devintensive.models.data.Chat
import ru.skillbranch.devintensive.models.data.ChatItem

fun Chat.toChatItem(): ChatItem {
    return if (isSingle()) {
        val user = members.first()
        ChatItem(
            id,
            user.avatar,
            Utils.toInitials(user.firstName, user.lastName) ?: "??",
            "${user.firstName ?: ""} ${user.lastName ?: ""}",
            lastMessageShort().first,
            unreadableMessageCount(),
            lastMessageDate()?.shortFormat(),
            user.isOnline
        )
    } else {
        ChatItem(
            id,
            null,
            "",
            title,
            lastMessageShort().first,
            unreadableMessageCount(),
            lastMessageDate()?.shortFormat(),
            false,
            if(id=="-1") ChatType.ARCHIVE else ChatType.GROUP,
            lastMessageShort().second
        )
    }
}

enum class ChatType(val layoutId:Int) {
    SINGLE(R.layout.item_chat_single),
    GROUP(R.layout.item_chat_group),
    ARCHIVE(R.layout.item_chat_archive)
}