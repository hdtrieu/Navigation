package com.hdtrieu.home

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.hdtrieu.navigator.quickNavigate

class HomeActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Log.d("HDT", "home activity")
        findViewById<Button>(R.id.go_to_detail_button).setOnClickListener {
            val id = findViewById<EditText>(R.id.editText).text?.toString() ?: ""
            quickNavigate("module://detail/$id", this) {}
        }
    }
}