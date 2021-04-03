package com.raion.furnitale.ui.categories.outdoor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.raion.furnitale.core.domain.usecase.ProductUseCase

class OutdoorViewModel(useCase: ProductUseCase) : ViewModel() {
    val outdoor = useCase.getOutdoorList().asLiveData()
}