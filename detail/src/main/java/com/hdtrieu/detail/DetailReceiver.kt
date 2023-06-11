package com.hdtrieu.detail

import com.hdtrieu.navigator.NavigatorReceiver
import com.hdtrieu.navigator.interfaces.NavigatorProcessor

class DetailReceiver: NavigatorReceiver() {
    override fun getListener(): NavigatorProcessor {
        return DetailProcessor()
    }
}