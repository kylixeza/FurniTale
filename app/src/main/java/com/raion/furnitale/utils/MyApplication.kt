package com.raion.furnitale.utils

import android.app.Application
import com.raion.furnitale.core.di.repositoryModule
import com.raion.furnitale.ui.di.useCaseModule
import com.raion.furnitale.ui.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}