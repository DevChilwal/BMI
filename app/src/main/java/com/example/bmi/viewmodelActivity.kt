//package com.example.bmi
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import androidx.lifecycle.MutableLiveData
//import android.widget.Toast
//import androidx.lifecycle.ViewModel
//import kotlin.math.round
//
//class viewmodelActivity : AppCompatActivity() {
//    var value1:MutableLiveData<Float> = MutableLiveData()
//    var value2:MutableLiveData<String> = MutableLiveData()
//
//    fun calculatebmi(hi:Double, wi:Int) {
//        val height: Double = hi / 100
//        var BMI = wi / (height * height)
//        var total = (round(BMI * 100) / 100.0)
//        value1.value = total.toFloat()
//
//
//        if (total < 18) {
//            text.value = "you are under weight"
//        } else if (total > 18 && total < 25) {
//            text.value = "you are healthy"
//        } else {
//            text.value = "you are over weight"
//        }
//
//    }
//}
//
//
//
//
//
////
////    override fun onCreate(savedInstanceState: Bundle?) {
////        super.onCreate(savedInstanceState)
////        setContentView(R.layout.activity_viewmodel)
////    }
//}