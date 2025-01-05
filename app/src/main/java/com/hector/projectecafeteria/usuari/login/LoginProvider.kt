package com.hector.projectecafeteria.usuari.login

class LoginProvider {
    companion object {
        fun loadLogins(): MutableList<LoginModel> {
            return mutableListOf<LoginModel>(
                LoginModel(
                    "pepe@gmail.com",
                    "pepe1234"
                ),
                LoginModel(
                    "jose@gmail.com",
                    "jose1234"
                ),
                LoginModel(
                    "adria@gmail.com",
                    "adria1234"
                ),
                LoginModel(
                    "pau@gmail.com",
                    "pau1234"
                ),
                LoginModel(
                    "Joan",
                    "joan1234"
                ),
                LoginModel(
                    "Dani",
                    "dani1234"
                )
            )
        }

        fun checkIfEntryExists(login: LoginModel): Boolean {
            val currentEntries = loadLogins()
            for (entry in currentEntries) {
                if (entry.nom == login.nom)
                    return true
            }

            return false
        }
    }
}