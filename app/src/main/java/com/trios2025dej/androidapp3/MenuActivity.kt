package com.trios2025dej.androidapp3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MenuActivity : AppCompatActivity() {

    private lateinit var recyclerMenu: RecyclerView
    private lateinit var btnViewCart: Button
    private lateinit var adapter: MenuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        recyclerMenu = findViewById(R.id.recyclerMenu)
        btnViewCart = findViewById(R.id.btnViewCart)

        val items = listOf(
            MenuItem(1, "Original Blend Coffee", 1.79, R.drawable.coffee),
            MenuItem(2, "Dark Roast Coffee", 1.99, R.drawable.coffee),
            MenuItem(3, "Latte", 3.49, R.drawable.coffee),
            MenuItem(4, "Iced Coffee", 2.49, R.drawable.coffee)
        )

        adapter = MenuAdapter(items) { item, size ->
            val updatedPrice = sizePrice(item.price, size)
            CartManager.addToCart(item.copy(price = updatedPrice))
        }

        recyclerMenu.layoutManager = LinearLayoutManager(this)
        recyclerMenu.adapter = adapter

        btnViewCart.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }
    }

    private fun sizePrice(base: Double, size: CoffeeSize): Double {
        return when (size) {
            CoffeeSize.SMALL -> base
            CoffeeSize.MEDIUM -> base + 0.50
            CoffeeSize.LARGE -> base + 1.00
        }
    }
}