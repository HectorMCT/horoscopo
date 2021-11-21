package org.hector.horoscopo.ui

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import org.hector.horoscopo.R
import org.hector.horoscopo.databinding.ActivityHoroscopeBinding
import org.hector.horoscopo.model.User
import org.hector.horoscopo.util.AppContent.horoscopes

class HoroscopeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHoroscopeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val persona: User? = intent.getParcelableExtra<Parcelable>("USER") as User?
        val relativeLayout = binding.rootRL

        if (persona != null) {
            for(horoscope in horoscopes){
                if (persona.date.split("/")[2].toInt() in horoscope.years){
                    relativeLayout.setBackgroundResource(horoscope.background)
                    binding.cardImage.setImageResource(horoscope.image)
                    binding.cardName.text = getString(R.string.name_format, persona.username)
                    binding.horoscopeMsg.text = getString(R.string.content_format, zodiacName(horoscope.name), decideMessage(horoscope.name))
                    binding.horoscopeSmsg.append(" " + decideCompatible(horoscope.name))
                    break
                }
            }
        }

        binding.returnMain.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }
    }

    private fun zodiacName(name: String): String{

        return when (name) {
            "Tiger" -> {getString(R.string.first_horoscope)}
            "Rabbit" -> {getString(R.string.second_horoscope)}
            "Dragon" -> {getString(R.string.third_horoscope)}
            "Snake" -> {getString(R.string.fourth_horoscope)}
            "Horse" -> {getString(R.string.five_horoscope)}
            "Goat" -> {getString(R.string.six_horoscope)}
            "Monkey" -> {getString(R.string.seven_horoscope)}
            "Rooster" -> {getString(R.string.eight_horoscope)}
            "Dog" -> {getString(R.string.nine_horoscope)}
            "Pig" -> {getString(R.string.ten_horoscope)}
            "Rat" -> {getString(R.string.eleven_horoscope)}
            "Ox" -> {getString(R.string.twelve_horoscope)}
            else -> {"Nadie"}
        }
    }


    private fun decideMessage(name: String): String{

        return when (name) {
            "Tiger" -> {getString(R.string.first_msg)}
            "Rabbit" -> {getString(R.string.second_msg)}
            "Dragon" -> {getString(R.string.third_msg)}
            "Snake" -> {getString(R.string.fourth_msg)}
            "Horse" -> {getString(R.string.five_msg)}
            "Goat" -> {getString(R.string.six_msg)}
            "Monkey" -> {getString(R.string.seven_msg)}
            "Rooster" -> {getString(R.string.eight_msg)}
            "Dog" -> {getString(R.string.nine_msg)}
            "Pig" -> {getString(R.string.ten_msg)}
            "Rat" -> {getString(R.string.eleven_msg)}
            "Ox" -> {getString(R.string.twelve_msg)}
            else -> {"Nadie"}
        }
    }

    private fun decideCompatible(name: String): String {
        return when (name) {
            "Tiger" -> {
                arrayListOf(getString(R.string.third_horoscope), getString(R.string.five_horoscope), getString(R.string.ten_horoscope)).joinToString()
            }
            "Rabbit" -> {
                arrayListOf(getString(R.string.eleven_horoscope), getString(R.string.six_horoscope), getString(R.string.seven_horoscope), getString(R.string.nine_horoscope), getString(R.string.ten_horoscope)).joinToString()
            }
            "Dragon" -> {
                arrayListOf(getString(R.string.eleven_horoscope), getString(R.string.first_horoscope), getString(R.string.fourth_horoscope)).joinToString()
            }
            "Snake" -> {
                arrayListOf(getString(R.string.third_horoscope), getString(R.string.eight_horoscope)).joinToString()
            }
            "Horse" -> {
                arrayListOf(getString(R.string.six_horoscope), getString(R.string.first_horoscope)).joinToString()
            }
            "Goat" -> {
                arrayListOf(getString(R.string.second_horoscope), getString(R.string.first_horoscope), getString(R.string.fourth_horoscope)).joinToString()
            }
            "Monkey" -> {
                arrayListOf(getString(R.string.twelve_horoscope), getString(R.string.second_horoscope)).joinToString()
            }
            "Rooster" -> {
                arrayListOf(getString(R.string.twelve_horoscope), getString(R.string.fourth_horoscope)).joinToString()
            }
            "Dog" -> {
                arrayListOf(getString(R.string.second_horoscope)).joinToString()
            }
            "Pig" -> {
                arrayListOf(getString(R.string.five_horoscope), getString(R.string.first_horoscope), getString(R.string.second_horoscope)).joinToString()
            }
            "Rat" -> {
                arrayListOf(getString(R.string.first_horoscope), getString(R.string.third_horoscope), getString(R.string.second_horoscope)).joinToString()
            }
            "Ox" -> {
                arrayListOf(getString(R.string.eleven_horoscope), getString(R.string.seven_horoscope), getString(R.string.eight_horoscope)).joinToString()
            }
            else -> {
                "Nothing"
            }
        }
    }
}