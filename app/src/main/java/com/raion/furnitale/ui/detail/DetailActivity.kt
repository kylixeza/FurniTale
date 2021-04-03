package com.raion.furnitale.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.raion.furnitale.R
import com.raion.furnitale.core.data.Resource
import com.raion.furnitale.core.domain.model.Product
import com.raion.furnitale.databinding.ActivityDetailBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    companion object {
        const val ID = "ID"
    }

    private lateinit var product: Product
    private val detailViewModel: DetailViewModel by viewModel()
    private var _detailBinding: ActivityDetailBinding? = null
    private val detailBinding get() = _detailBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding?.root)
        observeDetail()
    }

    private fun observeDetail() {
        val id = intent.getIntExtra(ID, 0)
        detailViewModel.detailProduct(id).observe(this, {
            when (it) {
                is Resource.Success -> {
                    product = it.data!!
                    detailBinding?.data = it.data
                }
                is Resource.Error -> {
                    detailBinding?.errorLayout?.apply {
                        tvErrorMessage.text = it.message
                        ivError.visibility = View.VISIBLE
                    }
                }
                is Resource.Loading -> {

                }
            }
        })
    }
}