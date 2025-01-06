package com.hector.projectecafeteria.compres.menjarFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MenjarViewModel : ViewModel() {

    private val _menjars = MutableLiveData<List<Menjar>>()
    val menjar: LiveData<List<Menjar>> = _menjars

    fun getMenjars() {
        _menjars.value = MenjarProvider.loadMenjar()
    }
}