package com.raion.furnitale.core.domain.usecase

import com.raion.furnitale.core.data.Resource
import com.raion.furnitale.core.domain.model.Product
import com.raion.furnitale.core.domain.repository.IProductRepository
import kotlinx.coroutines.flow.Flow

class ProductInteractor(private val productRepository: IProductRepository): ProductUseCase {
    override fun getLivingRoomList(): Flow<Resource<List<Product>>> = productRepository.getLivingRoomList()

    override fun getBedRoomList(): Flow<Resource<List<Product>>> = productRepository.getBedRoomList()

    override fun getKitchenList(): Flow<Resource<List<Product>>> = productRepository.getKitchenList()

    override fun getBathRoomList(): Flow<Resource<List<Product>>> = productRepository.getBathRoomList()

    override fun getOutdoorList(): Flow<Resource<List<Product>>> = productRepository.getOutdoorList()

    override fun getAccessoriesList(): Flow<Resource<List<Product>>> = productRepository.getAccessoriesList()

    override fun getDetailProduct(id: Int): Flow<Resource<Product>> = productRepository.getDetailProduct(id)

}