package com.hector.projectecafeteria.usuari.login

class LoginProvider {
    companion object {
        fun loadLogins(): MutableList<LoginModel> {
            return mutableListOf<LoginModel>(
                LoginModel(
                    "pepe",
                    "pepe1234"
                ),
                LoginModel(
                    "jose",
                    "jose1234"
                ),
                LoginModel(
                    "adria",
                    "adria1234"
                ),
                LoginModel(
                    "pau",
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