package org.hector.horoscopo.model

data class Horoscope(
    val name: String,
    var years: ArrayList<Int>,
    val background: Int,
    val image: Int) {

}