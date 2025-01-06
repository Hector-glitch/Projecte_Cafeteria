package com.hector.projectecafeteria.compres.postresFragment

import com.hector.projectecafeteria.compres.menjarFragment.Menjar

class PostresProvider {
    companion object {
        fun loadPostres(): List<Postres> {
            return listOf<Postres>(
                Postres(
                    "Croissant",
                    1.50,
                    "Croissant cassola de chocolata o sense res",
                    "https://images.pexels.com/photos/3892469/pexels-photo-3892469.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
                ),
                Postres(
                    "Crema Catalana",
                    3.88,
                    "Crema catalana cassolana feta al moment",
                    "https://recetasdecocina.elmundo.es/wp-content/uploads/2023/10/crema-catalana.jpg"
                ),
                Postres(
                    "Pastis d'arandan",
                    3.50,
                    "Arandans cultivas a catalunya",
                    "https://images.pexels.com/photos/1126359/pexels-photo-1126359.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
                ),
                Postres(
                    "Macarons",
                    4.20,
                    "Fets a mà i sense gluten",
                    "https://images.pexels.com/photos/808941/pexels-photo-808941.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
                ),
                Postres(
                    "Pastis de fruits del bosc",
                    6.99,
                    "",
                    "https://images.pexels.com/photos/2693447/pexels-photo-2693447.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
                ),
                Postres(
                    "Pancakes",
                    5.95,
                    "",
                    "https://images.pexels.com/photos/2280545/pexels-photo-2280545.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
                ),
                Postres(
                    "Copa de boal de gelat",
                    3.50,
                    "Numero de boles i sabor a eleccio",
                    "https://images.pexels.com/photos/2586924/pexels-photo-2586924.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
                ),
                Postres(
                    "Galetes amb llet",
                    4.09,
                    "",
                    "https://images.pexels.com/photos/1325467/pexels-photo-1325467.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
                ),
                Postres(
                    "Cupcakes",
                    6.09,
                    "Chocolata, galeta, nata o pistacho",
                    "https://images.pexels.com/photos/10563880/pexels-photo-10563880.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
                ),
                Postres(
                    "Calipo",
                    2.09,
                    "Maduixa, cola o lima",
                    "https://i.ytimg.com/vi/uoxl_ZjdYb0/maxresdefault.jpg"
                )
            )
        }
    }
}