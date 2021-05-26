package com.raion.furnitale.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.raion.furnitale.core.domain.model.Product
import com.raion.furnitale.databinding.ListCategoryBinding
import com.raion.furnitale.ui.search.SearchFragmentDirections

class SearchAdapter: RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    val searchList: ArrayList<Product> = ArrayList()

    fun setAllData(data: List<Product>) {
        searchList.clear()
        searchList.addAll(data)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = ListCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(searchList[position])
    }

    override fun getItemCount(): Int = searchList.size

    inner class SearchViewHolder(private val view: ListCategoryBinding): RecyclerView.ViewHolder(view.root) {
        fun bind(product: Product) {
            view.data = product
            itemView.setOnClickListener {
                it.findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToDetailActivity(product.id!!))
            }
        }
    }
}