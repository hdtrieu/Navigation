package com.hdtrieu.navigator.interfaces

import android.content.Context
import com.hdtrieu.navigator.utils.NavPriority

interface NavigatorProcessor {
    fun matches(deepLink: String) : Boolean
    fun execute(context: Context, params: NavigateParams, callback: TkActionNavigateCallback)
    fun weight(): NavPriority
}