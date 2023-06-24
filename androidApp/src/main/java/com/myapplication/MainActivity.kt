package com.myapplication

import MainView
import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import moe.tlaster.precompose.lifecycle.PreComposeActivity
import moe.tlaster.precompose.lifecycle.setContent

/**
 * created by Josue Lubaki
 * date : 2023-06-21
 * version : 1.0.0
 */

class MainActivity : PreComposeActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainView()
        }
    }
}