package com.raion.furnitale.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.raion.furnitale.core.domain.model.Product
import com.raion.furnitale.databinding.ItemListBinding
import com.raion.furnitale.ui.home.HomeFragmentDirections

class SelectionAdapter: RecyclerView.Adapter<SelectionAdapter.SelectionViewHolder>() {

    private var selectionList = ArrayList<Product>()

    fun setList(data: List<Product>) {
        selectionList.clear()
        selectionList.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectionViewHolder {
        val view = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SelectionViewHolder(view)
    }

    override fun onBindViewHolder(holder: SelectionViewHolder, position: Int) {
        holder.bind(product = selectionList[position], position)
    }

    override fun getItemCount(): Int = selectionList.size


    inner class SelectionViewHolder(private val view: ItemListBinding): RecyclerView.ViewHolder(view.root) {
        fun bind(product: Product, position: Int) {
            view.data = product
            itemView.setOnClickListener {
                it.findNavController().navigate(HomeFragmentDirections.actionHomeDestinationToDetailActivity(selectionList[position].id!!))
            }
        }
    }
}