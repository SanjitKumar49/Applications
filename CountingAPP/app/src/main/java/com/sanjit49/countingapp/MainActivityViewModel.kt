package com.sanjit49.countingapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
  //  var count= 0   view model concept
    var count=MutableLiveData<Int>()  //is live data that contain live data

    init {
        count.value=0
    }
    fun updateCount(){
        // ++count
        count.value=(count.value)?.plus(1)

    }
}