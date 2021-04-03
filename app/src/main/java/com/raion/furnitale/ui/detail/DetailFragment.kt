package com.raion.furnitale.ui.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.raion.furnitale.R
import com.raion.furnitale.core.data.Resource
import com.raion.furnitale.core.domain.model.Product
import com.raion.furnitale.databinding.DetailFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {

    private var _detailBinding: DetailFragmentBinding? = null
    private val detailBinding get() = _detailBinding
    private lateinit var product: Product
    private val detailViewModel: DetailViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _detailBinding = DetailFragmentBinding.inflate(layoutInflater, container, false)
        detailBinding?.lifecycleOwner = viewLifecycleOwner
        observeDetail()
        return detailBinding?.root
    }

    private fun observeDetail() {

        detailViewModel.detailProduct(1).observe(viewLifecycleOwner, {
            when(it) {
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
                    detailBinding?.errorLayout?.apply {
                        ivError.visibility = View.GONE
                    }
                }
            }
        })
    }

}