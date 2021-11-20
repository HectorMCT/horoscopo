package org.hector.horoscopo.model


import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class User(
    val username : String,
    val email : String,
    val count: String,
    val date: String) : Parcelable
