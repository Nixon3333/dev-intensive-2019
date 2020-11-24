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

    fun toInitials(firstName: String?, lastName: String?): String? {
        val initials = "${firstName?.getOrNull(0)?.toUpperCase() ?: ""}${lastName?.getOrNull(0)
            ?.toUpperCase() ?: ""}"
        return if (initials.isEmpty() || initials == " ") null else initials
    }

    fun transliteration(payload: String, divider: String = " "): String {
        val transMap = mapOf(
            "а" to "a",
            "б" to "b",
            "в" to "v",
            "г" to "g",
            "д" to "d",
            "е" to "e",
            "ё" to "e",
            "ж" to "zh",
            "з" to "z",
            "и" to "i",
            "й" to "i",
            "к" to "k",
            "л" to "l",
            "м" to "m",
            "н" to "n",
            "о" to "o",
            "п" to "p",
            "р" to "r",
            "с" to "s",
            "т" to "t",
            "у" to "u",
            "ф" to "f",
            "х" to "h",
            "ц" to "c",
            "ч" to "ch",
            "ш" to "sh",
            "щ" to "sh'",
            "ъ" to "",
            "ы" to "i",
            "ь" to "",
            "э" to "e",
            "ю" to "yu",
            "я" to "ya"
        )
        val transName = StringBuilder()
        for (char: Char in payload.toCharArray()) {
            val s = char.toLowerCase()
            if (s == ' ')
                transName.append(divider)
            else
                transName.append(transMap[s.toString()])
        }
        return transName.toString().split(divider).joinToString(divider) { it.capitalize() }
    }
}