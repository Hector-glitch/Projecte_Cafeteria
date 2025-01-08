package com.hector.projectecafeteria.compres

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.hector.projectecafeteria.R
import com.hector.projectecafeteria.compres.pagamentFragment.PagamentViewModel
import com.hector.projectecafeteria.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityHomeBinding
    private val orderSharedViewModel: OrderSharedViewModel by viewModels()
    private val pagamentViewModel: PagamentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Thread.sleep(3000)
        installSplashScreen()

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(binding.fragmentContainerViewTag.id) as NavHostFragment
        navController = navHostFragment.navController

        setupWithNavController(binding.bottomMenuView, navController)

        // Connecta PagamentViewModel amb OrderSharedViewModel
        pagamentViewModel.bindToOrderSharedViewModel(orderSharedViewModel)

        // Observar el LiveData del total i actualitzar el TextView
        orderSharedViewModel.total.observe(this) { total ->
            binding.totalPriceTextView.text = getString(R.string.total_price, "%.2f".format(total))
        }
    }
}
