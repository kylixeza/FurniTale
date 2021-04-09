package com.raion.furnitale.ui.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.raion.furnitale.core.domain.model.Product
import com.raion.furnitale.core.domain.usecase.ProductUseCase
import kotlinx.coroutines.launch

class CartViewModel(private val useCase: ProductUseCase) : ViewModel() {

    fun getCartList(userEmail: String?) = useCase.getCartList(userEmail).asLiveData()

    fun deleteProduct(product: Product) = viewModelScope.launch {
        useCase.deleteProduct(product)
    }

    fun insertProduct(product: Product) = viewModelScope.launch {
        useCase.insertProduct(product)
    }
}