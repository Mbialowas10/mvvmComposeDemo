package com.mike.mvvmdemo


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CounterViewModel() : ViewModel() {
    // idea is to hoist state and logic to this class so that it is saved or persisted
    // at app level

    var counter by mutableStateOf(0)

    fun increaseValue(){
        counter = counter + 1
    }

}