package com.hector.projectecafeteria.compres.postresFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PostresViewModel : ViewModel() {

    private val _postres = MutableLiveData<List<Postres>>()
    val postres: LiveData<List<Postres>> = _postres

    fun getPostres() {
        _postres.value = PostresProvider.loadPostres()
    }
}