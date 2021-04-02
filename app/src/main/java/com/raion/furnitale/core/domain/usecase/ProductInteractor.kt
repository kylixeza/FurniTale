package com.raion.furnitale.core.domain.usecase

import com.raion.furnitale.core.data.Resource
import com.raion.furnitale.core.domain.model.Product
import com.raion.furnitale.core.domain.repository.IProductRepository
import kotlinx.coroutines.flow.Flow

class ProductInteractor(private val productRepository: IProductRepository): ProductUseCase {
    override fun getDetailProduct(id: Int): Flow<Resource<Product>> = productRepository.getDetailProduct(id)

}