package com.raion.furnitale.ui.categories.bathroom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.raion.furnitale.core.domain.usecase.ProductUseCase
import com.raion.furnitale.core.domain.usecase.categories.CategoriesUseCase

class BathroomViewModel(useCase: CategoriesUseCase) : ViewModel() {
    val bathroom = useCase.getBathRoomList().asLiveData()
}