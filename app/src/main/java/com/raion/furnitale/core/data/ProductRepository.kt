package com.raion.furnitale.core.data

import com.raion.furnitale.core.data.source.local.LocalDataSource
import com.raion.furnitale.core.data.source.remote.RemoteDataSource
import com.raion.furnitale.core.data.source.remote.network.ApiResponse
import com.raion.furnitale.core.data.source.remote.response.ProductResponse
import com.raion.furnitale.core.domain.model.Product
import com.raion.furnitale.core.domain.repository.IProductRepository
import com.raion.furnitale.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProductRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
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

    override fun getSelectionProduct(): Flow<Resource<List<Product>>> {
        return object : NetworkOnlyResource<List<Product>, List<ProductResponse>>() {
            override fun loadFromNetwork(data: List<ProductResponse>): Flow<List<Product>> {
                return DataMapper.mapResponsesToDomain(data)
            }

            override suspend fun createCall(): Flow<ApiResponse<List<ProductResponse>>> {
                return  remoteDataSource.getSelectionProduct()
            }

        }.asFlow()
    }

    override fun getNewProduct(): Flow<Resource<List<Product>>> {
        return object : NetworkOnlyResource<List<Product>, List<ProductResponse>>() {
            override fun loadFromNetwork(data: List<ProductResponse>): Flow<List<Product>> {
                return DataMapper.mapResponsesToDomain(data)
            }

            override suspend fun createCall(): Flow<ApiResponse<List<ProductResponse>>> {
                return  remoteDataSource.getNewProduct()
            }

        }.asFlow()
    }

    override fun getAllDiscount(): Flow<Resource<List<String>>> {
        return object : NetworkOnlyResource<List<String>, List<String>>() {
            override fun loadFromNetwork(data: List<String>): Flow<List<String>> {
                return DataMapper.mapDiscount(data)
            }

            override suspend fun createCall(): Flow<ApiResponse<List<String>>> {
                return remoteDataSource.getAllDiscount()
            }

        }.asFlow()
    }

    override fun getCartList(userEmail: String?): Flow<List<Product>> =
        localDataSource.getCartList(userEmail).map {
            DataMapper.mapEntitiesToDomain(it)
        }


    override fun getTotalStuffs(key: String?): Flow<Product>? =
        localDataSource.getTotalStuffs(key)?.map {
            DataMapper.mapEntityToDomain(it)
        }


    override suspend fun insertProduct(product: Product) {
        val data = DataMapper.mapDomainToEntity(product)
        localDataSource.insertProduct(data)
    }

    override suspend fun deleteProduct(product: Product): Int {
        val data = DataMapper.mapDomainToEntity(product)
        return localDataSource.deleteProduct(data)
    }

    override suspend fun deleteAllProduct() {
        return localDataSource.deleteAllProduct()
    }


}