package com.raion.furnitale.ui.categories.livingroom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.raion.furnitale.core.domain.usecase.ProductUseCase
import com.raion.furnitale.core.domain.usecase.categories.CategoriesUseCase

class LivingRoomViewModel(useCase: CategoriesUseCase) : ViewModel() {
    val livingRoom = useCase.getLivingRoomList().asLiveData()
}