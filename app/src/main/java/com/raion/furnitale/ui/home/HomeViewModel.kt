package com.raion.furnitale.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.raion.furnitale.core.domain.usecase.ProductUseCase

class HomeViewModel(useCase: ProductUseCase) : ViewModel() {
    val selection = useCase.getSelectionProduct().asLiveData()
    val newProduct = useCase.getNewProduct().asLiveData()
    val discount = useCase.getAllDiscount().asLiveData()
    val categoryImage = useCase.getAllCategoryImage().asLiveData()
}