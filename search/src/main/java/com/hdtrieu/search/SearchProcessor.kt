package com.hdtrieu.search

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import com.hdtrieu.navigator.interfaces.NavigateParams
import com.hdtrieu.navigator.interfaces.NavigatorProcessor
import com.hdtrieu.navigator.interfaces.TkActionNavigateCallback
import com.hdtrieu.navigator.utils.NavPriority

class SearchProcessor: NavigatorProcessor {
    private lateinit var link: String
    override fun matches(deepLink: String): Boolean {
        if (deepLink.startsWith("module://search")) {
            link = deepLink
            return true
        }
        return false
    }

    override fun execute(
        context: Context,
        params: NavigateParams,
        callback: TkActionNavigateCallback
    ) {
        val uri = Uri.parse(link)
        val keyword = uri.getQueryParameter("keyword")
        Log.d("HDT", keyword.toString())
        val intent = Intent(context, SearchActivity::class.java)
        intent.putExtra("keyword", keyword)
        context.startActivity(intent)
        callback.onCompleted(true, null)
    }

    override fun weight(): NavPriority {
        return NavPriority.HIGH
    }
}