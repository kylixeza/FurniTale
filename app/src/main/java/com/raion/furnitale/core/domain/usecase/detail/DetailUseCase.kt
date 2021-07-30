package com.raion.furnitale.core.domain.usecase.detail

import com.raion.furnitale.core.data.Resource
import com.raion.furnitale.core.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface DetailUseCase {
    fun getDetailProduct(id: Int): Flow<Resource<Product>>
    fun getTotalStuffs(key: String): Flow<Product>?
    suspend fun insertProduct(product: Product)
}