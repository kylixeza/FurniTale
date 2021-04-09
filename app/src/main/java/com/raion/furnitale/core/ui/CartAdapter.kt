package com.raion.furnitale.core.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import cn.pedant.SweetAlert.SweetAlertDialog
import com.raion.furnitale.core.domain.model.Product
import com.raion.furnitale.databinding.ItemListCartBinding
import com.raion.furnitale.ui.cart.CartFragmentDirections
import com.raion.furnitale.ui.cart.CartViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CartAdapter(private val cartViewModel: CartViewModel, private val context: Context): RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private var cartList = ArrayList<Product>()

    fun settAllData(data: List<Product>) {
        cartList.clear()
        cartList.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = ItemListCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.apply {
            bind(product = cartList[position])
            deleteProduct(cartList[position])
            insertIncrement(cartList[position])
            insertDecrement(cartList[position])
        }
    }

    override fun getItemCount(): Int = cartList.size

    inner class CartViewHolder(private val view: ItemListCartBinding): RecyclerView.ViewHolder(view.root) {
        fun bind(product: Product) {
            view.data = product
            itemView.setOnClickListener {
                it.findNavController().navigate(CartFragmentDirections.actionCartDestinationToDetailActivity(product.id!!))
            }
        }

        fun deleteProduct(product: Product) {
            view.tvDelete.setOnClickListener {
                val sweetAlertDelete = SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                sweetAlertDelete.setTitleText("Delete This Product?")
                    .setConfirmText("YES")
                    .setCancelText("NO")
                    .setConfirmClickListener {
                        GlobalScope.launch {
                            cartViewModel.deleteProduct(product)
                        }
                        it.confirmText = "OK"
                        it.cancelText = null
                        it.setConfirmClickListener(null)
                        it.changeAlertType(SweetAlertDialog.SUCCESS_TYPE)
                    }
                    .setCancelClickListener {
                        sweetAlertDelete.cancel()
                    }
                    sweetAlertDelete.show()
            }
        }

        fun insertIncrement(product: Product) {
            view.btnInsertIncrement.setOnClickListener {
                val incrementStuffs = product.totalStuffs?.plus(1)
                product.totalStuffs = incrementStuffs
                GlobalScope.launch {
                    cartViewModel.insertProduct(product)
                }
            }
        }

        fun insertDecrement(product: Product) {
            view.btnInsertDecrement.setOnClickListener {
               if (product.totalStuffs!! > 1) {
                   val decrementStuffs = product.totalStuffs?.minus(1)
                   product.totalStuffs = decrementStuffs
                   GlobalScope.launch {
                       cartViewModel.insertProduct(product)
                   }
               }
            }
        }
    }
}