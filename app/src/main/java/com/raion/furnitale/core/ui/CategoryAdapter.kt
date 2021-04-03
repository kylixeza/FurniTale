package com.raion.furnitale.core.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raion.furnitale.core.domain.model.Product
import com.raion.furnitale.databinding.ListCategoryBinding
import com.raion.furnitale.ui.detail.DetailActivity
import com.raion.furnitale.ui.detail.DetailActivity.Companion.ID

class CategoryAdapter(private val context: Context): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private var categories = ArrayList<Product>()

    fun setAll(data: List<Product>) {
        categories.clear()
        categories.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = ListCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    override fun getItemCount(): Int = categories.size


    inner class CategoryViewHolder(private val view: ListCategoryBinding): RecyclerView.ViewHolder(view.root) {
        fun bind(product: Product) {
            view.data = product
            itemView.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java).apply {
                    putExtra(ID, product.id)
                }
                itemView.context.startActivity(intent)
            }
        }
    }
}