package com.trios2025dej.androidapp3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMenu: Button = findViewById(R.id.btnMenu)
        val btnViewCart: Button = findViewById(R.id.btnViewCart)

        btnMenu.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }

        btnViewCart.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }
    }
}