package com.raion.furnitale.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.raion.furnitale.core.domain.model.Product
import com.raion.furnitale.core.domain.usecase.ProductUseCase
import kotlinx.coroutines.launch

class DetailViewModel(private val useCase: ProductUseCase) : ViewModel() {

    fun detailProduct(id: Int) = useCase.getDetailProduct(id).asLiveData()

    fun getTotalStuffs(key: String) = useCase.getTotalStuffs(key)?.asLiveData()

    fun insertProduct(product: Product) = viewModelScope.launch {
        useCase.insertProduct(product)
    }
}