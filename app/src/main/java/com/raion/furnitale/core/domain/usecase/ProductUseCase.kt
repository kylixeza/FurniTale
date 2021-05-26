package com.raion.furnitale.core.domain.usecase

import com.raion.furnitale.core.data.Resource
import com.raion.furnitale.core.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductUseCase {

    fun getLivingRoomList(): Flow<Resource<List<Product>>>
    fun getBedRoomList(): Flow<Resource<List<Product>>>
    fun getKitchenList(): Flow<Resource<List<Product>>>
    fun getBathRoomList(): Flow<Resource<List<Product>>>
    fun getOutdoorList(): Flow<Resource<List<Product>>>
    fun getAccessoriesList(): Flow<Resource<List<Product>>>
    fun getDetailProduct(id: Int): Flow<Resource<Product>>
    fun getSelectionProduct(): Flow<Resource<List<Product>>>
    fun getNewProduct(): Flow<Resource<List<Product>>>
    fun getSearchProducts(query: String): Flow<Resource<List<Product>>>
    fun getAllDiscount(): Flow<Resource<List<String>>>
    fun getAllCategoryImage(): Flow<Resource<List<String>>>

    fun getCartList(userEmail: String?): Flow<List<Product>>
    fun getTotalStuffs(key: String): Flow<Product>?
    suspend fun insertProduct(product: Product)
    suspend fun deleteProduct(product: Product): Int
    suspend fun deleteAllProduct()
}