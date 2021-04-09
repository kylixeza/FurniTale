package com.raion.furnitale.core.data.source.local

import com.raion.furnitale.core.data.source.local.entity.ProductEntity
import com.raion.furnitale.core.data.source.local.room.ProductDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val productDao: ProductDao) {

    fun getCartList(userEmail: String?): Flow<List<ProductEntity>> = productDao.getCartList(userEmail)

    fun getTotalStuffs(key: String?): Flow<ProductEntity>? = productDao.getTotalStuffs(key)

    suspend fun insertProduct(product: ProductEntity) = productDao.insertProduct(product)

    suspend fun deleteProduct(product: ProductEntity) = productDao.deleteProduct(product)

    suspend fun deleteAllProduct() = productDao.deleteAllProduct()
}