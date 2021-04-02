package com.raion.furnitale.core.domain.usecase

import com.raion.furnitale.core.data.Resource
import com.raion.furnitale.core.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductUseCase {

    fun getDetailProduct(id: Int): Flow<Resource<Product>>
}