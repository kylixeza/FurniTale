package com.raion.furnitale.ui.categories.outdoor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.raion.furnitale.core.domain.usecase.ProductUseCase
import com.raion.furnitale.core.domain.usecase.categories.CategoriesUseCase

class OutdoorViewModel(useCase: CategoriesUseCase) : ViewModel() {
    val outdoor = useCase.getOutdoorList().asLiveData()
}