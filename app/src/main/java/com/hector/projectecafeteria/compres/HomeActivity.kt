package com.hector.projectecafeteria.compres

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.hector.projectecafeteria.databinding.ActivityHomeBinding
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class HomeActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Thread.sleep(3000)
        installSplashScreen()

        val binding = ActivityHomeBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(binding.fragmentContainerViewTag.id) as NavHostFragment
        navController = navHostFragment.navController

        val bottomNavigationView = binding.bottomMenuView

        setupWithNavController(bottomNavigationView, navController)
    }
}