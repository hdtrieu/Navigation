package com.hdtrieu.home

import android.util.Log
import com.hdtrieu.navigator.NavigatorReceiver
import com.hdtrieu.navigator.interfaces.NavigatorProcessor

class HomeReceiver: NavigatorReceiver() {
    override fun getListener(): NavigatorProcessor {
        Log.d("HDT", "get listener")
        return HomeProcessor()
    }
}