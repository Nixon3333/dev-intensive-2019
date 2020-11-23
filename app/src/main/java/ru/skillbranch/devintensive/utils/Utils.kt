package ru.skillbranch.devintensive.utils

/**
 * Created by Drygin Nikita on 22,Ноябрь,2020
 */
object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")
        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
        return if (firstName.equals("")) null to null
                else firstName to lastName
    }

    fun toInitials(firstName: String?, lastName: String?) : String? {
        val initials = "${firstName?.getOrNull(0)?.toUpperCase() ?: ""}${lastName?.getOrNull(0)?.toUpperCase() ?: ""}"
        return if (initials.isEmpty() || initials == " ") null else initials
    }
}