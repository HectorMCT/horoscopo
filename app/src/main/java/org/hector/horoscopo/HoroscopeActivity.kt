package org.hector.horoscopo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.hector.horoscopo.databinding.ActivityHoroscopeBinding

class HoroscopeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHoroscopeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHoroscopeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val relativeLayout = binding.rootRL

        val images = intArrayOf(R.drawable.rat, R.drawable.ox, R.drawable.tigre, R.drawable.rabbit,
            R.drawable.dragon, R.drawable.snake, R.drawable.horse, R.drawable.goat, R.drawable.monkey,
            R.drawable.rooster, R.drawable.dog, R.drawable.pig)

        relativeLayout.setBackgroundResource(images[1])
    }
}