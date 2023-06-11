package com.hdtrieu.navigator

import android.app.Activity
import android.os.Bundle

class DeepLinkDispatcherActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val uri = intent.data!!
        if (quickNavigate(uri.toString(), this) {
            finish()
        }) {
            finish()
        }
    }
}