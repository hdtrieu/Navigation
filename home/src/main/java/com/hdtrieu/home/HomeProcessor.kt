package com.hdtrieu.home

import android.content.Context
import android.content.Intent
import android.util.Log
import com.hdtrieu.navigator.interfaces.NavigateParams
import com.hdtrieu.navigator.interfaces.NavigatorProcessor
import com.hdtrieu.navigator.interfaces.TkActionNavigateCallback
import com.hdtrieu.navigator.utils.NavPriority

class HomeProcessor: NavigatorProcessor {
    override fun matches(deepLink: String): Boolean {
        return deepLink.startsWith("module://home")
    }

    override fun execute(
        context: Context,
        params: NavigateParams,
        callback: TkActionNavigateCallback
    ) {
        Log.d("HDT", "start home")
        context.startActivity(Intent(context, HomeActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP))
        callback.onCompleted(true, null)
    }

    override fun weight(): NavPriority {
        return NavPriority.HIGH
    }
}