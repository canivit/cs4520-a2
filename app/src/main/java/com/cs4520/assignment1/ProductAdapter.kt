package com.cs4520.assignment1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.cs4520.assignment1.data.Equipment
import com.cs4520.assignment1.data.Food
import com.cs4520.assignment1.data.Product

class ProductAdapter(private val dataSet: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productImageView: ImageView
        val productNameView: TextView
        val productExpiryDateView: TextView
        val productPriceView: TextView

        init {
            productImageView = view.findViewById(R.id.product_image)
            productNameView = view.findViewById(R.id.product_name)
            productExpiryDateView = view.findViewById(R.id.product_expiry_date)
            productPriceView = view.findViewById(R.id.product_price)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = dataSet[position]
        holder.productNameView.text = product.name
        holder.productPriceView.text = String.format(
            holder.itemView.context.getString(R.string.default_product_price),
            product.price
        )
        when (product) {
            is Equipment -> {
                holder.itemView.setBackgroundColor(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.equipment_product_background
                    )
                )

                holder.productExpiryDateView.visibility = View.GONE
                holder.productImageView.setImageResource(R.drawable.equipment)
            }

            is Food -> {
                holder.itemView.setBackgroundColor(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.food_product_background
                    )
                )

                holder.productExpiryDateView.visibility = View.VISIBLE
                holder.productExpiryDateView.text = product.expiryDate
                holder.productImageView.setImageResource(R.drawable.food)
            }
        }
    }
}