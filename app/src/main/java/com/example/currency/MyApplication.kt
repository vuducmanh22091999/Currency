package com.example.currency

import android.app.Application
import com.example.currency.di.appModule
import com.example.currency.di.repositoryModule
import com.example.currency.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(listOf(appModule, repositoryModule, viewModelModule))
        }
    }
}