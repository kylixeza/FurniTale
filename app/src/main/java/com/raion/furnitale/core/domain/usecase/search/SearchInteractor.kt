package com.raion.furnitale.core.domain.usecase.search

import com.raion.furnitale.core.data.Resource
import com.raion.furnitale.core.domain.model.Product
import com.raion.furnitale.core.domain.repository.IProductRepository
import kotlinx.coroutines.flow.Flow

class SearchInteractor(private val repository: IProductRepository): SearchUseCase {
    override fun getSearchProducts(query: String): Flow<Resource<List<Product>>> {
        return repository.getSearchProducts(query)
    }
}