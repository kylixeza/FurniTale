package com.raion.furnitale.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.raion.furnitale.databinding.ItemListDiscountBinding

class DiscountAdapter: RecyclerView.Adapter<DiscountAdapter.DiscountViewHolder>() {

    private var discountList = ArrayList<String>()

    fun setData(data: List<String>) {
        discountList.clear()
        discountList.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscountViewHolder {
        val view = ItemListDiscountBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DiscountViewHolder(view)
    }

    override fun onBindViewHolder(holder: DiscountViewHolder, position: Int) {
        holder.bind(discountList[position])
    }

    override fun getItemCount(): Int = discountList.size

    class DiscountViewHolder(private val view: ItemListDiscountBinding): RecyclerView.ViewHolder(view.root) {
        fun bind(s: String) {
            Glide.with(view.root)
                .load(s)
                .into(view.ivImageDiscount)
        }
    }
}