package com.raion.furnitale.core.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raion.furnitale.core.domain.model.Product
import com.raion.furnitale.databinding.ItemListCartCheckoutBinding
import com.raion.furnitale.utils.Formatting

class CartCheckoutAdapter: RecyclerView.Adapter<CartCheckoutAdapter.CartCheckoutViewHolder>() {

    private var listCartCheckout = ArrayList<Product>()

    fun setData(data: List<Product>) {
        listCartCheckout.clear()
        listCartCheckout.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartCheckoutViewHolder {
        val view = ItemListCartCheckoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartCheckoutViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartCheckoutViewHolder, position: Int) {
        holder.bind(listCartCheckout[position])
    }

    override fun getItemCount(): Int = listCartCheckout.size

    inner class CartCheckoutViewHolder(private val view: ItemListCartCheckoutBinding): RecyclerView.ViewHolder(view.root) {
        @SuppressLint("SetTextI18n")
        fun bind(product: Product) {
            view.data = product
            val price = product.totalStuffs?.let { product.realPrice?.times(it) }
            view.tvPriceCartCheckout.text = "Rp ${price?.let { Formatting.rupiahCurrencyFormatting(it) }}"
        }
    }
}