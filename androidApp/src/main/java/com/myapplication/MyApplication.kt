package com.myapplication

import android.app.Application
import di.initKoin
import org.koin.android.ext.koin.androidContext

/**
 * created by Josue Lubaki
 * date : 2023-06-24
 * version : 1.0.0
 */

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin(){
            androidContext(this@MyApplication)
        }
    }
}