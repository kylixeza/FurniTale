package com.raion.furnitale.ui.cart

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import cn.pedant.SweetAlert.SweetAlertDialog
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.raion.furnitale.R
import com.raion.furnitale.core.domain.model.Product
import com.raion.furnitale.core.ui.CartAdapter
import com.raion.furnitale.core.ui.CartCheckoutAdapter
import com.raion.furnitale.databinding.CartFragmentBinding
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_list_cart.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class CartFragment : Fragment() {

    private var _cartBinding: CartFragmentBinding? = null
    private val cartBinding get() = _cartBinding
    private val cartViewModel: CartViewModel by viewModel()
    private lateinit var cartAdapter: CartAdapter
    private val cartCheckoutAdapter: CartCheckoutAdapter by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _cartBinding = CartFragmentBinding.inflate(layoutInflater, container, false)
        return cartBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val account = GoogleSignIn.getLastSignedInAccount(context)

        cartAdapter = activity?.let { CartAdapter(cartViewModel, it) }!!

        observeCart(account)

        cartBinding?.rvCart?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = cartAdapter
        }

        cartBinding?.includeCartCheckout?.rvAllCheckout?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = cartCheckoutAdapter
        }
    }

    private fun observeCart(account: GoogleSignInAccount?) {
        cartViewModel.getCartList(account?.email).observe(viewLifecycleOwner, {
            if (it.isNullOrEmpty()) {
                cartBinding?.includeEmptyCart?.apply {
                    ivAddCart.visibility = View.VISIBLE
                    tvAddCart.visibility = View.VISIBLE
                }
            } else {
                cartBinding?.includeEmptyCart?.apply {
                    ivAddCart.visibility = View.INVISIBLE
                    tvAddCart.visibility = View.INVISIBLE
                }
            }
            cartCheckoutAdapter.setData(it)
            cartAdapter.settAllData(it)
            totalPrice(it)
            if (it.isNotEmpty()) {
                checkout()
            }
        })
    }

    @SuppressLint("SetTextI18n")
    private fun totalPrice(listProduct: List<Product>) {
        var totalPrice = 0
        for (product in listProduct) {
            totalPrice += (product.totalStuffs?.let { product.realPrice?.times(it) }!!)
        }
        cartBinding?.includeCartCheckout?.tvPaymentTotalReal?.text = "Rp $totalPrice"
    }
    
    private fun checkout() {
        cartBinding?.includeCartCheckout?.buttonCheckout?.setOnClickListener {
            val checkoutDialog = SweetAlertDialog(activity, SweetAlertDialog.NORMAL_TYPE)
            checkoutDialog.apply {
                titleText = "Checkout Products?"
                confirmText = "YES"
                cancelText = "NO"
                setConfirmClickListener {
                    cartViewModel.deleteAllProduct()
                    it.titleText = "Checkout Success"
                    it.confirmText = "OK"
                    it.cancelText = null
                    it.setConfirmClickListener(null)
                    it.changeAlertType(SweetAlertDialog.SUCCESS_TYPE)
                }
                setCancelClickListener {
                    it.cancel()
                }
                show()
            }
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _cartBinding = null
    }
}