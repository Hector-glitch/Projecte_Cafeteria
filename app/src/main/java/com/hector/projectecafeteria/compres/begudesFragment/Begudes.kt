package com.hector.projectecafeteria.compres.begudesFragment

import com.hector.projectecafeteria.compres.utils.ItemWithPrice

data class Begudes(val name: String, override val price: Double, val description: String, val photo: String): ItemWithPrice
