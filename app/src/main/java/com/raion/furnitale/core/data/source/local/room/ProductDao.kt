package com.raion.furnitale.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.raion.furnitale.core.data.source.local.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Query("SELECT * FROM product_table WHERE user_email = :userEmail")
    fun getCartList(userEmail: String?): Flow<List<ProductEntity>>

    @Query("SELECT * FROM product_table WHERE user_email = :userEmail")
    fun getTotalStuffs(userEmail: String?): Flow<ProductEntity>?

    @Insert
    suspend fun insertProduct(product: ProductEntity)

    @Update
    fun updateProduct(product: ProductEntity)
}