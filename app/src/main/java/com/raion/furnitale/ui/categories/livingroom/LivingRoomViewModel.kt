package com.raion.furnitale.ui.categories.livingroom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.raion.furnitale.core.domain.usecase.ProductUseCase

class LivingRoomViewModel(useCase: ProductUseCase) : ViewModel() {
    val livingRoom = useCase.getLivingRoomList().asLiveData()
}