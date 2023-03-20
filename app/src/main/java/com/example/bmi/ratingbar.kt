package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmi.databinding.ActivityRatingbarBinding
import android.content.ContentValues.TAG
import android.util.Log
import android.widget.RatingBar

class ratingbar : AppCompatActivity(), RatingBar.OnRatingBarChangeListener {
    private lateinit var binding: ActivityRatingbarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRatingbarBinding.inflate(layoutInflater)
         setContentView(binding.ratingbar)
        binding.ratingbar.onRatingBarChangeListener = this
    }
    override fun onRatingChanged(ratingBar: RatingBar?, rating:Float, fromUser:Boolean)
    {
       Log.d(TAG,"onRatingChanged :" +ratingBar?.rating)
    }
}

  private fun RatingBar.onRatingBarChangedListener(ratingBar: RatingBar?)
  {

  }