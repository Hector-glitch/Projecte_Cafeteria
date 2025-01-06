package com.hector.projectecafeteria.compres.menjarFragment

import com.hector.projectecafeteria.compres.utils.ItemWithPrice

data class Menjar(val name: String, override val price: Double, val description: String, val photo: String) : ItemWithPrice
