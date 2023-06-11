package com.hdtrieu.navigator

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.hdtrieu.navigator.interfaces.NavigatorProcessor

/**
 * Broadcast receiver for register module processor
 */
abstract class NavigatorReceiver : BroadcastReceiver() {
    companion object {
        const val ACTION_REGISTER = "com.hdtrieu.navigator.ACTION_REGISTER"
    }

    override fun onReceive(context: Context?, intent: Intent?) {

    }

    /**
     * override this method by return your module processor
     */
    abstract fun getListener(): NavigatorProcessor?
}