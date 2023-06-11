package com.hdtrieu.navigator.utils

import com.hdtrieu.navigator.interfaces.NavigatorProcessor

class NavigatorCompare: Comparator<NavigatorProcessor> {
    override fun compare(o1: NavigatorProcessor, o2: NavigatorProcessor): Int {
        return o1.weight().priority - o2.weight().priority
    }
}