package com.trios2025dej.androidapp3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(
    private val items: List<MenuItem>,
    private val onAddToCart: (MenuItem, CoffeeSize) -> Unit
) : RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgItem: ImageView = view.findViewById(R.id.imgItem)
        val txtName: TextView = view.findViewById(R.id.txtName)
        val radioSmall: RadioButton = view.findViewById(R.id.radioSmall)
        val radioMedium: RadioButton = view.findViewById(R.id.radioMedium)
        val radioLarge: RadioButton = view.findViewById(R.id.radioLarge)
        val btnAdd: Button = view.findViewById(R.id.btnAddCart)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_menu, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.txtName.text = item.name
        holder.imgItem.setImageResource(item.imageResId)

        holder.btnAdd.setOnClickListener {

            val size = when {
                holder.radioMedium.isChecked -> CoffeeSize.MEDIUM
                holder.radioLarge.isChecked -> CoffeeSize.LARGE
                else -> CoffeeSize.SMALL
            }

            onAddToCart(item, size)

            Toast.makeText(
                holder.itemView.context,
                "Added to cart",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun getItemCount(): Int = items.size
}