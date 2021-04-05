package com.raion.furnitale.core.data.source.local

import com.raion.furnitale.core.data.source.local.entity.ProductEntity
import com.raion.furnitale.core.data.source.local.room.ProductDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val productDao: ProductDao) {

    fun getCartList(userEmail: String?): Flow<List<ProductEntity>> = productDao.getCartList(userEmail)

    fun getTotalStuffs(userEmail: String?): Flow<ProductEntity>? = productDao.getTotalStuffs(userEmail)

    suspend fun insertProduct(product: ProductEntity) = productDao.insertProduct(product)

    fun updateProduct(product: ProductEntity) = productDao.updateProduct(product)

}