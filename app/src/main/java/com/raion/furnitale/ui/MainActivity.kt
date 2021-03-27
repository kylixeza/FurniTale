package com.raion.furnitale.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.raion.furnitale.R
import com.raion.furnitale.databinding.ActivityMainBinding
import com.raion.furnitale.ui.account.AccountFragment
import com.raion.furnitale.ui.cart.CartFragment
import com.raion.furnitale.ui.chat.ChatFragment
import com.raion.furnitale.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        loadFragment(HomeFragment())
        mainBinding.bottomNav.setOnNavigationItemSelectedListener(bottomNavigationView)
    }

    private val bottomNavigationView = BottomNavigationView.OnNavigationItemSelectedListener {
        when(it.itemId) {
            R.id.nav_home -> loadFragment(HomeFragment())
            R.id.nav_chat -> loadFragment(ChatFragment())
            R.id.nav_cart -> loadFragment(CartFragment())
            R.id.nav_account -> loadFragment(AccountFragment())
        }
        true
    }

    private fun loadFragment(fragment: Fragment?): Boolean {
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fm_container, fragment)
                .commit()
            return true
        }
        return false
    }
}