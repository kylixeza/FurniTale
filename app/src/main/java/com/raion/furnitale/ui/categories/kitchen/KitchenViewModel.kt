package com.raion.furnitale.ui.categories.kitchen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.raion.furnitale.core.domain.usecase.ProductUseCase

class KitchenViewModel(useCase: ProductUseCase) : ViewModel() {
    val kitchen = useCase.getKitchenList().asLiveData()
}