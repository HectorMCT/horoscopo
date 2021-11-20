package org.hector.horoscopo.ui

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
                    binding.cardName.text = horoscope.name
                    binding.horoscopeMsg.text = horoscope.message
                    binding.horoscopeSmsg.append(horoscope.compatible.joinToString())
                    break
                }
            }
        }
    }
}