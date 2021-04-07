package com.raion.furnitale.core.data.source.local.room

import androidx.room.*
import com.raion.furnitale.core.data.source.local.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Query("SELECT * FROM product_table WHERE user_email = :userEmail")
    fun getCartList(userEmail: String?): Flow<List<ProductEntity>>

    @Query("SELECT * FROM product_table WHERE `key` = :key")
    fun getTotalStuffs(key: String?): Flow<ProductEntity>?

    @Query("SELECT * FROM product_table WHERE `key` = :key")
    fun checkProductIsExist(key: String?): Flow<ProductEntity>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: ProductEntity)

    @Update
    fun updateProduct(product: ProductEntity)
}