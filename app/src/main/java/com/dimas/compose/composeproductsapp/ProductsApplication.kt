package com.dimas.compose.composeproductsapp

import android.app.Application
import com.dimas.compose.composeproductsapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ProductsApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@ProductsApplication)
            modules(appModule)
        }
    }
}