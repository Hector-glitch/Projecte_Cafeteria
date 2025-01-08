package com.hector.projectecafeteria.compres

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hector.projectecafeteria.compres.pagamentFragment.Item

class OrderSharedViewModel : ViewModel() {

    private val _customerOrder = mutableListOf<Item>()
    private val _total = MutableLiveData<Double>()
    val total: LiveData<Double> get() = _total

    private val _order = MutableLiveData<List<Item>>()
    val order: LiveData<List<Item>> get() = _order

    fun getOrder() {
        _order.value = _customerOrder
    }

    fun addElementToOrder(element: Item) {
        _customerOrder.add(element)
        calculateTotal()
    }

    fun calculateTotal() {
        val newTotal = _customerOrder.sumOf { it.price }
        _total.value = newTotal
    }
}
