package com.raion.furnitale.core.data

import com.raion.furnitale.core.data.source.local.LocalDataSource
import com.raion.furnitale.core.data.source.remote.RemoteDataSource
import com.raion.furnitale.core.data.source.remote.network.ApiResponse
import com.raion.furnitale.core.data.source.remote.response.ProductResponse
import com.raion.furnitale.core.domain.model.Product
import com.raion.furnitale.core.domain.repository.IProductRepository
import com.raion.furnitale.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow

class ProductRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
    ): IProductRepository {

    override fun getDetailProduct(id: Int): Flow<Resource<Product>> {
        return object : NetworkOnlyResource<Product, ProductResponse>() {
            override fun loadFromNetwork(data: ProductResponse): Flow<Product> {
                return DataMapper.mapResponseToDomain(data)
            }

            override suspend fun createCall(): Flow<ApiResponse<ProductResponse>> {
                return remoteDataSource.getDetailProduct(id)
            }

        }.asFlow()
    }


}