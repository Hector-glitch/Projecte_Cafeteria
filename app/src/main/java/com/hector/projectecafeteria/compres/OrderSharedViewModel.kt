package com.hector.projectecafeteria.compres

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hector.projectecafeteria.compres.pagamentFragment.Item

class OrderSharedViewModel : ViewModel() {
    var customerOrder = mutableListOf<Item>()
    var total: Double = 0.0

    private val _order = MutableLiveData<MutableList<Item>>()
    val order: LiveData<MutableList<Item>> = _order


    fun getOrder() {
        _order.value = customerOrder
    }

    fun addElementToOrder(element: Item) {
        customerOrder.add(element)
    }

    fun calculateTotal() {
        total = 0.0

        for (element: Item in customerOrder) {
            total += element.price
        }
    }
}