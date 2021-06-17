package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {


    //define MutableLiveData object to hold live data
    val message = MutableLiveData<String>()

    //function to capture data to be shared
    fun sendMessage(text: String){

        message.value = text

    }
}