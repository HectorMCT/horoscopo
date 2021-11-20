package org.hector.horoscopo.util

import java.util.regex.Pattern

object FieldValidators {

    fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isValidCount(count: String): Boolean {
        return when {
            Pattern.matches("[0-9]+", count) -> {
                true
            }
            else -> false
        }
    }

    fun isValidDate(date: String): Boolean {
        return when {
            Pattern.matches("(3[01]|[12][0-9]|0?[1-9])/(0?[1-9]|1[012])/[0-9]{4}", date) -> {
                true
            }
            else -> false
        }
    }
}