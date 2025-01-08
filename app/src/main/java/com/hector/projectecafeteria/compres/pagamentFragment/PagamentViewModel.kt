package com.hector.projectecafeteria.compres.pagamentFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hector.projectecafeteria.compres.OrderSharedViewModel

class PagamentViewModel : ViewModel() {

    lateinit var total: LiveData<Double>

    fun bindToOrderSharedViewModel(orderSharedViewModel: OrderSharedViewModel) {
        total = orderSharedViewModel.total
    }
}