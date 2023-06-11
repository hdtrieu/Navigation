package com.hdtrieu.navigator

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.os.Build
import android.util.Log
import com.hdtrieu.navigator.NavigatorReceiver.Companion.ACTION_REGISTER
import com.hdtrieu.navigator.interfaces.NavigateParams
import com.hdtrieu.navigator.interfaces.NavigatorProcessor
import com.hdtrieu.navigator.interfaces.TkActionNavigateCallback
import com.hdtrieu.navigator.utils.NavigatorCompare
import java.lang.reflect.Method

const val TAG = "Navigator"
private val navigatorListenerHolder: ArrayList<NavigatorProcessor> = ArrayList()

@SuppressLint("QueryPermissionsNeeded")
fun registerNavigatorListener(context: Context) {
    val mainIntent = Intent(ACTION_REGISTER)
    val pkgAppsList: List<ResolveInfo> = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        context.packageManager.queryBroadcastReceivers(mainIntent,
            PackageManager.ResolveInfoFlags.of(0))
    } else {
        context.packageManager.queryBroadcastReceivers(mainIntent, 0);
    }

    navigatorListenerHolder.toSortedSet(NavigatorCompare())

    for (resolveInfo in pkgAppsList) {
        try {
            val process: Class<*> = Class.forName(resolveInfo.activityInfo.name)
            val method: Method = process.getMethod("getListener")
            val listener = method.invoke(process.newInstance())
            Log.d("HDT", listener.javaClass.name)
            if (listener != null) navigatorListenerHolder.add(listener as NavigatorProcessor)
        } catch (ex: ClassNotFoundException) {
            ex.printStackTrace()
        } catch (ex: NoSuchMethodException) {
            ex.printStackTrace()
        }
    }

    Log.d(TAG, "size: " + navigatorListenerHolder.size)
}

fun navigate(data: NavigateParams, context: Context, callback: TkActionNavigateCallback): Boolean {
    navigatorListenerHolder.forEach{
        if (it.matches(data.getLink())) {
            it.execute(context, data, callback)
            return true
        }
    }

    return false
}

fun quickNavigate(deepLink: String, context: Context, onLaunched: () -> Unit): Boolean {
    val link = object : NavigateParams {
        override fun getLink(): String {
            return deepLink
        }

        override fun getParams(): Map<String, Any>? {
            return null
        }
    }
    return navigate(link, context, object : TkActionNavigateCallback {
        override fun onCompleted(success: Boolean, bundle: Map<String, Any>?) {
            onLaunched.invoke()
        }

        override fun onFailure(error: String) {

        }
    })
}
