package com.raion.furnitale.core.domain.usecase.detail

import com.raion.furnitale.core.data.Resource
import com.raion.furnitale.core.domain.model.Product
import com.raion.furnitale.core.domain.repository.IProductRepository
import kotlinx.coroutines.flow.Flow

class DetailInteractor(private val repository: IProductRepository): DetailUseCase {
    override fun getDetailProduct(id: Int): Flow<Resource<Product>> {
        return repository.getDetailProduct(id)
    }

    override fun getTotalStuffs(key: String): Flow<Product>? {
        return repository.getTotalStuffs(key)
    }

    override suspend fun insertProduct(product: Product) {
        repository.insertProduct(product)
    }
}