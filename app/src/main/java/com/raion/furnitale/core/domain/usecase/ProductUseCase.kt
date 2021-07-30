package com.raion.furnitale.core.domain.usecase

import com.raion.furnitale.core.data.Resource
import com.raion.furnitale.core.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductUseCase {

    fun getLivingRoomList(): Flow<Resource<List<Product>>>//done
    fun getBedRoomList(): Flow<Resource<List<Product>>>//done
    fun getKitchenList(): Flow<Resource<List<Product>>>//done
    fun getBathRoomList(): Flow<Resource<List<Product>>>//done
    fun getOutdoorList(): Flow<Resource<List<Product>>>//done
    fun getAccessoriesList(): Flow<Resource<List<Product>>>//done
    fun getDetailProduct(id: Int): Flow<Resource<Product>> //done
    fun getSelectionProduct(): Flow<Resource<List<Product>>> //done
    fun getNewProduct(): Flow<Resource<List<Product>>> //done
    fun getSearchProducts(query: String): Flow<Resource<List<Product>>> //done
    fun getAllDiscount(): Flow<Resource<List<String>>> //done
    fun getAllCategoryImage(): Flow<Resource<List<String>>> //done

    fun getCartList(userEmail: String?): Flow<List<Product>>
    fun getTotalStuffs(key: String): Flow<Product>?
    suspend fun insertProduct(product: Product)
    suspend fun deleteProduct(product: Product): Int
    suspend fun deleteAllProduct()
}