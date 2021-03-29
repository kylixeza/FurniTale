package com.raion.furnitale.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.raion.furnitale.R
import com.raion.furnitale.databinding.ActivityMainBinding
import com.raion.furnitale.ui.account.AccountFragment
import com.raion.furnitale.ui.cart.CartFragment
import com.raion.furnitale.ui.chat.ChatFragment
import com.raion.furnitale.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        setSupportActionBar(mainBinding.toolbar)

        navController = findNavController(R.id.nav_host)
        NavigationUI.setupWithNavController(mainBinding.bottomNav, navController)

        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        navController.navigateUp(appBarConfiguration)
        return super.onSupportNavigateUp()
    }
}