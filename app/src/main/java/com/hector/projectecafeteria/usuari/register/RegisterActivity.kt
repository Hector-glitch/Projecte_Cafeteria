package com.hector.projectecafeteria.usuari.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.hector.projectecafeteria.compres.HomeActivity
import com.hector.projectecafeteria.databinding.ActivityRegisterBinding
import com.hector.projectecafeteria.usuari.login.LoginModel

class RegisterActivity : AppCompatActivity() {
    private val viewModel: RegisterViewModel by viewModels()
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Toast.makeText(this, "Wrong login credentials", Toast.LENGTH_SHORT).show()
        viewModel.loadLogins()

        binding.RegisterButton.setOnClickListener {
            val emailText = binding.InputNom.text.toString()
            val passwordText = binding.InputPassword.text.toString()

            val newLogin = LoginModel(emailText, passwordText)

            if (!viewModel.checkAlreadyExistingLogin(newLogin)) {
                viewModel.addNewLogin(newLogin)
                viewModel.loadLogins()
                Toast.makeText(this, "Created login successfully!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Login already exists!", Toast.LENGTH_SHORT).show()
            }
        }
    }

}