package com.raion.furnitale.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.raion.furnitale.core.domain.usecase.ProductUseCase

class DetailViewModel(private val useCase: ProductUseCase) : ViewModel() {

    fun detailProduct(id: Int) = useCase.getDetailProduct(id).asLiveData()

}