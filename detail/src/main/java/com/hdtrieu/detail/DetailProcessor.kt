package com.hdtrieu.detail

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.hdtrieu.navigator.interfaces.NavigateParams
import com.hdtrieu.navigator.interfaces.NavigatorProcessor
import com.hdtrieu.navigator.interfaces.TkActionNavigateCallback
import com.hdtrieu.navigator.utils.NavPriority

class DetailProcessor: NavigatorProcessor {

    private lateinit var link: String
    override fun matches(deepLink: String): Boolean {
        if (deepLink.startsWith("module://detail")) {
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
        val id = uri.lastPathSegment
        context.startActivity(Intent(context, DetailActivity::class.java).putExtra("productId", id))
    }

    override fun weight(): NavPriority {
        return NavPriority.HIGH
    }
}