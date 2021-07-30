package com.raion.furnitale.ui.categories.bedroom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.raion.furnitale.core.domain.usecase.ProductUseCase
import com.raion.furnitale.core.domain.usecase.categories.CategoriesUseCase

class BedroomViewModel(useCase: CategoriesUseCase) : ViewModel() {
    val bedroom = useCase.getBedRoomList().asLiveData()
}