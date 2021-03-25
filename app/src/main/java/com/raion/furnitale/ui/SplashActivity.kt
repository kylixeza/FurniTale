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

    private var _splashBinding: ActivitySplashBinding? = null
    private val splashBinding get() = _splashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _splashBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(splashBinding?.root)

        val splashHandler = Handler(mainLooper)

        splashHandler.postDelayed({
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, TIME_FOR_SPLASH)
    }

    override fun onDestroy() {
        _splashBinding = null
        super.onDestroy()
    }
}
