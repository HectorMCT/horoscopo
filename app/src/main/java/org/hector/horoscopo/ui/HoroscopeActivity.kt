package org.hector.horoscopo.ui

import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
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
                    relativeLayout.setBackgroundResource(horoscope.image)
                    break
                }
            }
        }

        //val images = intArrayOf(R.drawable.rat, R.drawable.ox, R.drawable.tigre, R.drawable.rabbit,
        //    R.drawable.dragon, R.drawable.snake, R.drawable.horse, R.drawable.goat, R.drawable.monkey,
        //    R.drawable.rooster, R.drawable.dog, R.drawable.pig)

    }
}