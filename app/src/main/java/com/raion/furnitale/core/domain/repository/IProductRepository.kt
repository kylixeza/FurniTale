package com.raion.furnitale.core.domain.repository

import com.raion.furnitale.core.data.Resource
import com.raion.furnitale.core.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface IProductRepository {

    fun getDetailProduct(id: Int): Flow<Resource<Product>>
}