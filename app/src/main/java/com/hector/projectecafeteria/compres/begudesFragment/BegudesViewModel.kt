package com.hector.projectecafeteria.compres.begudesFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BegudesViewModel : ViewModel() {

    private val _begudes = MutableLiveData<List<Begudes>>()
    val begudes: LiveData<List<Begudes>> = _begudes

    fun getBegudes() {
        _begudes.value = BegudesProvider.loadBegudes()
    }
}