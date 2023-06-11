package com.hdtrieu.search

import com.hdtrieu.navigator.NavigatorReceiver
import com.hdtrieu.navigator.interfaces.NavigatorProcessor

class SearchReceiver: NavigatorReceiver() {
    override fun getListener(): NavigatorProcessor {
        return SearchProcessor()
    }
}