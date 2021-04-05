package com.raion.furnitale.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.navArgs
import com.raion.furnitale.R
import com.raion.furnitale.core.data.Resource
import com.raion.furnitale.core.domain.model.Product
import com.raion.furnitale.databinding.ActivityDetailBinding
import com.raion.furnitale.ui.home.HomeFragmentDirections
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding?.root)
        observeDetail()
    }

    private fun observeDetail() {
        var id = intent.getIntExtra(ID, -1)
        if (id == -1) {
            id = args.id
        }
        detailViewModel.detailProduct(id).observe(this, {
            when (it) {
                is Resource.Success -> {
                    product = it.data!!
                    detailBinding?.data = it.data
                }
                is Resource.Error -> {

                }
                is Resource.Loading -> {

                }
            }
        })
    }
}