package com.example.bmi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.roundToInt

class ViewModelBmi() : ViewModel()
{
    var count:MutableLiveData<Double> = MutableLiveData()
    var bmi: LiveData<Double> = count
    var statusofhealth : MutableLiveData<String> = MutableLiveData()
    var baseObservable : Observable = Observable()
    var errormsg: MutableLiveData<String> = MutableLiveData()

    fun validate() {
        if (baseObservable.height.isBlank() && baseObservable.weight.isBlank())
        {
            errormsg.value = " plz enter height and weight "
        }
        else if(baseObservable.height.isBlank())
        {
            errormsg.value = " plz enter height"
        }
        else if (baseObservable.weight.isBlank())
        {
            errormsg.value = " plz enter the weight "
        }
        else
        {

            val Height_in_metre = baseObservable.height.toFloat() / 100
            val total = baseObservable.weight.toFloat() / (Height_in_metre * Height_in_metre)
            val BMI = (total * 100).roundToInt() / 100.0


            if (BMI < 18.5)
            {
                statusofhealth.value = " Your BMI is :- $BMI \n You are Under Weight"
                count.value = x
            }
            else if (BMI >= 18.5 && BMI < 24.9)
            {
                statusofhealth.value = " Your BMI is :- $BMI \n You are Healthy"
                count.value = x
            }
            else if (BMI >= 24.9 && BMI < 30)
            {
                statusofhealth.value= " Your BMI is :- $BMI \n Your are Over Weight"
                count.value = x
            }
            else
            {
                statusofhealth.value=" Your BMI is :- $BMI \n You Are Suffering from Obesity"
                count.value = x
            }






        }
    }



}
