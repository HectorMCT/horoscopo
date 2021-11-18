package org.hector.horoscopo

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



}