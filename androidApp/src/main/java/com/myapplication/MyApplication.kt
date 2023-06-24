package com.myapplication

import android.app.Application
import di.initKoin

/**
 * created by Josue Lubaki
 * date : 2023-06-24
 * version : 1.0.0
 */

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin()
    }
}