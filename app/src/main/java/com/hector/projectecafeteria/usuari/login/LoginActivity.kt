package com.hector.projectecafeteria.usuari.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import com.hector.projectecafeteria.compres.HomeActivity
import com.hector.projectecafeteria.databinding.ActivityLoginBinding
import com.hector.projectecafeteria.usuari.register.RegisterActivity

class LoginActivity : AppCompatActivity() {
    private val viewModel: LoginViewModel by viewModels()
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getLogins()
        val loginsArray: MutableList<LoginModel>? = viewModel.login.value

        binding.LoginButton.setOnClickListener {
            val emailText = binding.InputNom.text.toString()
            val passwordText = binding.InputPassword.text.toString()

            val result = viewModel.checkEmailPw(loginsArray, emailText, passwordText)
            if (result) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
        }
    }

}