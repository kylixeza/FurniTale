package com.raion.furnitale.ui.categories.bathroom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.raion.furnitale.core.domain.usecase.ProductUseCase

class BathroomViewModel(useCase: ProductUseCase) : ViewModel() {
    val bathroom = useCase.getBathRoomList().asLiveData()
}