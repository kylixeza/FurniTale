package com.raion.furnitale.core.domain.usecase.search

import com.raion.furnitale.core.data.Resource
import com.raion.furnitale.core.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface SearchUseCase {
    fun getSearchProducts(query: String): Flow<Resource<List<Product>>>
}