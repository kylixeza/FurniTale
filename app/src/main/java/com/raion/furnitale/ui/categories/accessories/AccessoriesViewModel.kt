package com.raion.furnitale.ui.categories.accessories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.raion.furnitale.core.domain.usecase.ProductUseCase

class AccessoriesViewModel(useCase: ProductUseCase) : ViewModel() {
    val accessories = useCase.getAccessoriesList().asLiveData()
}