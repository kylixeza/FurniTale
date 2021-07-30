package com.raion.furnitale.ui.categories.accessories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.raion.furnitale.core.domain.usecase.ProductUseCase
import com.raion.furnitale.core.domain.usecase.categories.CategoriesUseCase

class AccessoriesViewModel(useCase: CategoriesUseCase) : ViewModel() {
    val accessories = useCase.getAccessoriesList().asLiveData()
}