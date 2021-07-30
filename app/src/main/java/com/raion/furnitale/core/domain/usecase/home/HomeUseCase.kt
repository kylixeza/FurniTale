package com.raion.furnitale.core.domain.usecase.home

import com.raion.furnitale.core.data.Resource
import com.raion.furnitale.core.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface HomeUseCase {
    fun getSelectionProduct(): Flow<Resource<List<Product>>>
    fun getNewProduct(): Flow<Resource<List<Product>>>
    fun getAllDiscount(): Flow<Resource<List<String>>>
    fun getAllCategoryImage(): Flow<Resource<List<String>>>
}