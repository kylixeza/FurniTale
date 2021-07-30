package com.raion.furnitale.ui.categories.kitchen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.raion.furnitale.core.domain.usecase.ProductUseCase
import com.raion.furnitale.core.domain.usecase.categories.CategoriesUseCase

class KitchenViewModel(useCase: CategoriesUseCase) : ViewModel() {
    val kitchen = useCase.getKitchenList().asLiveData()
}