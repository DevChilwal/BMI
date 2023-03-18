package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmi.databinding.ActivityRatingbarBinding

class ratingbar : AppCompatActivity() {
    private lateinit var binding: ActivityRatingbarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRatingbarBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.ratingBar)
    }
}
