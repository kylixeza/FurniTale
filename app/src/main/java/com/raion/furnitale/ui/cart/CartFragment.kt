package com.raion.furnitale.ui.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.raion.furnitale.core.ui.CartAdapter
import com.raion.furnitale.databinding.CartFragmentBinding
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class CartFragment : Fragment() {

    private var _cartBinding: CartFragmentBinding? = null
    private val cartBinding get() = _cartBinding
    private val cartViewModel: CartViewModel by viewModel()
    private val cartAdapter: CartAdapter by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _cartBinding = CartFragmentBinding.inflate(layoutInflater, container, false)
        return cartBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val account = GoogleSignIn.getLastSignedInAccount(context)

        observeCart(account)

        cartBinding?.rvCart?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = cartAdapter
        }


    }

    private fun observeCart(account: GoogleSignInAccount?) {
        cartViewModel.getCartList(account?.email).observe(viewLifecycleOwner, {
            cartAdapter.settAllData(it)
        })
    }
}