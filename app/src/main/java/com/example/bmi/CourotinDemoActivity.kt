package com.example.bmi

import android.os.Bundle
import android.util.Log
import android.view.View

import androidx.appcompat.app.AppCompatActivity
import com.example.bmi.databinding.ActivityCourotinDemoBinding

class CourotinDemoActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding:ActivityCourotinDemoBinding
    var count:Int= 0
    val TAG = "coroutine"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_courotin_demo)


        binding.btnClick.setOnClickListener(this)
        binding.btnDownload.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_click -> {
                count++
                Log.d(TAG, "onClick : $count")
            }

            R.id.btn_download -> {
                downloading()
            }
        }
    }
        private fun downloading()
        {
            for (i in 1..1000)
            {
                Log.d(TAG, "downloading :$i ")
            }
        }
    }