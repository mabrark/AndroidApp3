package com.trios2025dej.androidapp3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CartActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var txtTotal: TextView
    private lateinit var btnClearCart: Button
    private lateinit var btnCheckout: Button
    private lateinit var cartAdapter: CartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        recyclerView = findViewById(R.id.recyclerViewCart)
        txtTotal = findViewById(R.id.txtCartTotal)
        btnClearCart = findViewById(R.id.btnClearCart)
        btnCheckout = findViewById(R.id.btnCheckout)

        cartAdapter = CartAdapter(CartManager.items) {
            updateTotal()
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = cartAdapter



        updateTotal()

        btnClearCart.setOnClickListener {
            CartManager.clearCart()
            cartAdapter.notifyDataSetChanged()
            updateTotal()
        }

        btnCheckout.setOnClickListener {
            startActivity(Intent(this, OrderConfirmedActivity::class.java))
        }
    }

    private fun updateTotal() {
        txtTotal.text = "Total: $" + String.format("%.2f", CartManager.getTotalPrice())
    }
}