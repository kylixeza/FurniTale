package com.raion.furnitale.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.navArgs
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.raion.furnitale.core.data.Resource
import com.raion.furnitale.core.domain.model.Product
import com.raion.furnitale.databinding.ActivityDetailBinding
import com.shashank.sony.fancytoastlib.FancyToast
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    companion object {
        const val ID = "ID"
    }

    private lateinit var product: Product
    private val detailViewModel: DetailViewModel by viewModel()
    private var _detailBinding: ActivityDetailBinding? = null
    private val detailBinding get() = _detailBinding
    private val args: DetailActivityArgs by navArgs()
    private lateinit var key: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding?.root)

        val account = GoogleSignIn.getLastSignedInAccount(this)

        observeDetail(account)

        detailBinding?.btnAddToCart?.setOnClickListener {
            product.userEmail = account?.email
            product.totalStuffs = product.totalStuffs?.plus(1)
            detailViewModel.insertProduct(product)
            FancyToast.makeText(this, "Add To Cart", FancyToast.SUCCESS, FancyToast.LENGTH_SHORT, false).show()
        }
    }

    private fun observeDetail(account: GoogleSignInAccount?) {
        var id = intent.getIntExtra(ID, -1)
        if (id == -1) {
            id = args.id
        }
        detailViewModel.detailProduct(id).observe(this, {
            when (it) {
                is Resource.Success -> {
                    product = it.data!!
                    detailBinding?.data = it.data
                    key = String.format("${product.id}${account?.email}")
                    product.key = key
                    detailViewModel.getTotalStuffs(product.key!!)?.observe(this, { productStuffs ->
                        product.totalStuffs = productStuffs.totalStuffs
                    })
                }
                is Resource.Error -> {

                }
                is Resource.Loading -> {

                }
            }
        })
    }
}