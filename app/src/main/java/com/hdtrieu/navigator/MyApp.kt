package com.hdtrieu.navigator

import android.app.Application

open class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        registerNavigatorListener(this)
    }
}