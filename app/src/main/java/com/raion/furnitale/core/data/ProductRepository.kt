package com.raion.furnitale.core.data

import com.raion.furnitale.core.data.source.remote.RemoteDataSource
import com.raion.furnitale.core.data.source.remote.network.ApiResponse
import com.raion.furnitale.core.data.source.remote.response.ProductResponse
import com.raion.furnitale.core.domain.model.Product
import com.raion.furnitale.core.domain.repository.IProductRepository
import com.raion.furnitale.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow

class ProductRepository(
    private val remoteDataSource: RemoteDataSource
    ): IProductRepository {
    override fun getLivingRoomList(): Flow<Resource<List<Product>>> {
        return object : NetworkOnlyResource<List<Product>, List<ProductResponse>>() {
            override fun loadFromNetwork(data: List<ProductResponse>): Flow<List<Product>> {
                return DataMapper.mapResponsesToDomain(data)
            }

            override suspend fun createCall(): Flow<ApiResponse<List<ProductResponse>>> {
                return remoteDataSource.getLivingRoomList()
            }

        }.asFlow()
    }

    override fun getBedRoomList(): Flow<Resource<List<Product>>> {
        return object : NetworkOnlyResource<List<Product>, List<ProductResponse>>() {
            override fun loadFromNetwork(data: List<ProductResponse>): Flow<List<Product>> {
                return DataMapper.mapResponsesToDomain(data)
            }

            override suspend fun createCall(): Flow<ApiResponse<List<ProductResponse>>> {
                return remoteDataSource.getBedRoomList()
            }

        }.asFlow()
    }

    override fun getKitchenList(): Flow<Resource<List<Product>>> {
        return object : NetworkOnlyResource<List<Product>, List<ProductResponse>>() {
            override fun loadFromNetwork(data: List<ProductResponse>): Flow<List<Product>> {
                return DataMapper.mapResponsesToDomain(data)
            }

            override suspend fun createCall(): Flow<ApiResponse<List<ProductResponse>>> {
                return remoteDataSource.getKitchenList()
            }

        }.asFlow()
    }

    override fun getBathRoomList(): Flow<Resource<List<Product>>> {
        return object : NetworkOnlyResource<List<Product>, List<ProductResponse>>() {
            override fun loadFromNetwork(data: List<ProductResponse>): Flow<List<Product>> {
                return DataMapper.mapResponsesToDomain(data)
            }

            override suspend fun createCall(): Flow<ApiResponse<List<ProductResponse>>> {
                return remoteDataSource.getBathRoomList()
            }

        }.asFlow()
    }

    override fun getOutdoorList(): Flow<Resource<List<Product>>> {
        return object : NetworkOnlyResource<List<Product>, List<ProductResponse>>() {
            override fun loadFromNetwork(data: List<ProductResponse>): Flow<List<Product>> {
                return DataMapper.mapResponsesToDomain(data)
            }

            override suspend fun createCall(): Flow<ApiResponse<List<ProductResponse>>> {
                return remoteDataSource.getOutdoorList()
            }

        }.asFlow()
    }

    override fun getAccessoriesList(): Flow<Resource<List<Product>>> {
        return object : NetworkOnlyResource<List<Product>, List<ProductResponse>>() {
            override fun loadFromNetwork(data: List<ProductResponse>): Flow<List<Product>> {
                return DataMapper.mapResponsesToDomain(data)
            }

            override suspend fun createCall(): Flow<ApiResponse<List<ProductResponse>>> {
                return remoteDataSource.getAccessoriesList()
            }

        }.asFlow()
    }

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