package com.raion.furnitale.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.raion.furnitale.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    companion object {
        const val TIME_FOR_SPLASH = 2000L
    }

    private lateinit var splashBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(splashBinding.root)

        val splashHandler = Handler(mainLooper)

        splashHandler.postDelayed({
            val intent = Intent(this@SplashActivity, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }, TIME_FOR_SPLASH)
    }
}
