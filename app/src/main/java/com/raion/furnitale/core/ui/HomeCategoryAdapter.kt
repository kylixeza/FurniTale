package com.raion.furnitale.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.raion.furnitale.databinding.ItemListHomeCategoryBinding
import com.raion.furnitale.ui.home.HomeFragmentDirections

class HomeCategoryAdapter: RecyclerView.Adapter<HomeCategoryAdapter.HomeCategoryViewHolder>() {

    private val homeCategoryList = ArrayList<String>()

    fun setAllData(data: List<String>) {
        homeCategoryList.clear()
        homeCategoryList.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCategoryViewHolder {
        val view = ItemListHomeCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeCategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeCategoryViewHolder, position: Int) {
        holder.bind(homeCategoryList[position], position)
    }

    override fun getItemCount(): Int = homeCategoryList.size

    class HomeCategoryViewHolder(private val view: ItemListHomeCategoryBinding): RecyclerView.ViewHolder(view.root) {
        fun bind(url: String, position: Int) {
            Glide.with(view.root)
                .load(url)
                .into(view.ivListHomeCategory)
            view.ivListHomeCategory.setOnClickListener {
                it.findNavController().navigate(HomeFragmentDirections.actionHomeDestinationToCategoryActivity(position))
            }
        }
    }
}