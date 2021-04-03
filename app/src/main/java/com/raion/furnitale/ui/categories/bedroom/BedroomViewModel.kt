package com.raion.furnitale.ui.categories.bedroom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.raion.furnitale.core.domain.usecase.ProductUseCase

class BedroomViewModel(useCase: ProductUseCase) : ViewModel() {
    val bedroom = useCase.getBedRoomList().asLiveData()
}