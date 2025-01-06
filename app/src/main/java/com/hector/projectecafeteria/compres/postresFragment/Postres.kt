package com.hector.projectecafeteria.compres.postresFragment

import com.hector.projectecafeteria.compres.utils.ItemWithPrice

data class Postres(val name: String, override val price: Double, val description: String, val photo: String) : ItemWithPrice
