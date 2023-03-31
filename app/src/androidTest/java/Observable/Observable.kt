package com.example.bmi

import androidx.compose.ui.Modifier
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

class Observable : BaseObservable() {
    @get:Bindable

    var height : String = ""
        set(value)
        {
            field = value
            notifyPropertyChanged(BR.)
        }

    @get:Bindable

    var weight : String = " "
        set(value)
        {
            field = value
            notifyPropertyChanged(BR.weight)
        }
}