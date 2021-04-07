package com.raion.furnitale.core.data.source.local

import com.raion.furnitale.core.data.source.local.entity.ProductEntity
import com.raion.furnitale.core.data.source.local.room.ProductDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val productDao: ProductDao) {

    fun getCartList(userEmail: String?): Flow<List<ProductEntity>> = productDao.getCartList(userEmail)

    fun getTotalStuffs(key: String?): Flow<ProductEntity>? = productDao.getTotalStuffs(key)

    fun checkProductIsExist(key: String?): Flow<ProductEntity>? = productDao.checkProductIsExist(key)

    suspend fun insertProduct(product: ProductEntity) = productDao.insertProduct(product)

    fun updateProduct(product: ProductEntity) = productDao.updateProduct(product)

}