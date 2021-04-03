package com.raion.furnitale.ui.di

import com.raion.furnitale.core.domain.usecase.ProductInteractor
import com.raion.furnitale.core.domain.usecase.ProductUseCase
import com.raion.furnitale.ui.categories.accessories.AccessoriesViewModel
import com.raion.furnitale.ui.categories.bathroom.BathroomViewModel
import com.raion.furnitale.ui.categories.bedroom.BedroomViewModel
import com.raion.furnitale.ui.categories.kitchen.KitchenViewModel
import com.raion.furnitale.ui.categories.livingroom.LivingRoomViewModel
import com.raion.furnitale.ui.categories.outdoor.OutdoorViewModel
import com.raion.furnitale.ui.detail.DetailViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<ProductUseCase> { ProductInteractor(get()) }
}

val viewModelModule = module {
    viewModel { DetailViewModel(get()) }
    viewModel { LivingRoomViewModel(get()) }
    viewModel { BedroomViewModel(get()) }
    viewModel { KitchenViewModel(get()) }
    viewModel { BathroomViewModel(get()) }
    viewModel { OutdoorViewModel(get()) }
    viewModel { AccessoriesViewModel(get()) }
}