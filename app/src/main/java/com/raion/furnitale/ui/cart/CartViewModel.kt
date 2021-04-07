package com.raion.furnitale.ui.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.raion.furnitale.core.domain.usecase.ProductUseCase

class CartViewModel(private val useCase: ProductUseCase) : ViewModel() {

    fun getCartList(userEmail: String?) = useCase.getCartList(userEmail).asLiveData()
}