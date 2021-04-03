package com.raion.furnitale.core.domain.repository

import com.raion.furnitale.core.data.Resource
import com.raion.furnitale.core.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface IProductRepository {

    fun getLivingRoomList(): Flow<Resource<List<Product>>>
    fun getBedRoomList(): Flow<Resource<List<Product>>>
    fun getKitchenList(): Flow<Resource<List<Product>>>
    fun getBathRoomList(): Flow<Resource<List<Product>>>
    fun getOutdoorList(): Flow<Resource<List<Product>>>
    fun getAccessoriesList(): Flow<Resource<List<Product>>>
    fun getDetailProduct(id: Int): Flow<Resource<Product>>
}