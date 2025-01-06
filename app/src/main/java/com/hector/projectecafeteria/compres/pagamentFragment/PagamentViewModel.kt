package com.hector.projectecafeteria.compres.pagamentFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hector.projectecafeteria.compres.OrderSharedViewModel

class PagamentViewModel : ViewModel() {

    private val _total = MutableLiveData<Double>()
    val total: LiveData<Double> = _total

    fun getTotal(orderSharedViewModel: OrderSharedViewModel) {
        orderSharedViewModel.calculateTotal()

        _total.value = orderSharedViewModel.total
    }
}