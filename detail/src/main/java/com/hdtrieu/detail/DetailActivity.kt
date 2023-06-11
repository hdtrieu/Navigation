package com.hdtrieu.detail

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.hdtrieu.navigator.quickNavigate
import kotlin.random.Random

class DetailActivity : Activity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val id = intent?.getStringExtra("productId")
        findViewById<TextView>(R.id.content).text =
            """
                product detail page for id: $id
                random number is: ${random()}
            """.trimIndent()

        findViewById<Button>(R.id.to_home_button).setOnClickListener {
            quickNavigate("module://home", this) {
                finish()
            }
        }
    }

    private fun random(): Int {
        return Random.nextInt(100, 999)
    }
}
