package com.trios2025dej.androidapp3

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class OrderConfirmedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_confirmed)

        val btnBackHome: Button = findViewById(R.id.btnBackHome)
        btnBackHome.setOnClickListener {
            finish() // go back (likely to Main or Cart depending on stack)
        }
    }
}
