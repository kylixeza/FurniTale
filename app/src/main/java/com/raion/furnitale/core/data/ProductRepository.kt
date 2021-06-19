package com.raion.furnitale.core.data

import com.raion.furnitale.core.data.source.firestore.FirestoreDataSource
import com.raion.furnitale.core.data.source.firestore.network.FirestoreResponse
import com.raion.furnitale.core.data.source.firestore.response.ProductFirestoreResponse
import com.raion.furnitale.core.data.source.local.LocalDataSource
import com.raion.furnitale.core.data.source.remote.RemoteDataSource
import com.raion.furnitale.core.data.source.remote.network.ApiResponse
import com.raion.furnitale.core.data.source.remote.response.ProductResponse
import com.raion.furnitale.core.domain.model.Product
import com.raion.furnitale.core.domain.repository.IProductRepository
import com.raion.furnitale.core.utils.DataMapper
import com.raion.furnitale.core.utils.FirestoreMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProductRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val firestoreDataSource: FirestoreDataSource
    ): IProductRepository {
    override fun getLivingRoomList(): Flow<Resource<List<Product>>> {

        return object : FirestoreOnlyResource<List<Product>, List<ProductFirestoreResponse>>() {
            override fun loadFromNetwork(data: List<ProductFirestoreResponse>): Flow<List<Product>> {
                return FirestoreMapper.mapResponsesToDomain(data)
            }

            override suspend fun createCall(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>> {
                return firestoreDataSource.getLivingRoomList()
            }

        }.asFlow()
    }

    override fun getBedRoomList(): Flow<Resource<List<Product>>> {
       return object : FirestoreOnlyResource<List<Product>, List<ProductFirestoreResponse>>() {
           override fun loadFromNetwork(data: List<ProductFirestoreResponse>): Flow<List<Product>> {
               return FirestoreMapper.mapResponsesToDomain(data)
           }

           override suspend fun createCall(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>> {
               return firestoreDataSource.getBedroomList()
           }
       }.asFlow()
    }

    override fun getKitchenList(): Flow<Resource<List<Product>>> {
        return object : FirestoreOnlyResource<List<Product>, List<ProductFirestoreResponse>>() {
            override fun loadFromNetwork(data: List<ProductFirestoreResponse>): Flow<List<Product>> {
                return FirestoreMapper.mapResponsesToDomain(data)
            }

            override suspend fun createCall(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>> {
                return firestoreDataSource.getKitchenList()
            }
        }.asFlow()
    }

    override fun getBathRoomList(): Flow<Resource<List<Product>>> {
        return object : FirestoreOnlyResource<List<Product>, List<ProductFirestoreResponse>>() {
            override fun loadFromNetwork(data: List<ProductFirestoreResponse>): Flow<List<Product>> {
                return FirestoreMapper.mapResponsesToDomain(data)
            }

            override suspend fun createCall(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>> {
                return firestoreDataSource.getBathroomList()
            }
        }.asFlow()
    }

    override fun getOutdoorList(): Flow<Resource<List<Product>>> {
        return object : FirestoreOnlyResource<List<Product>, List<ProductFirestoreResponse>>() {
            override fun loadFromNetwork(data: List<ProductFirestoreResponse>): Flow<List<Product>> {
                return FirestoreMapper.mapResponsesToDomain(data)
            }

            override suspend fun createCall(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>> {
                return firestoreDataSource.getOutdoorList()
            }
        }.asFlow()
    }

    override fun getAccessoriesList(): Flow<Resource<List<Product>>> {
        return object : FirestoreOnlyResource<List<Product>, List<ProductFirestoreResponse>>() {
            override fun loadFromNetwork(data: List<ProductFirestoreResponse>): Flow<List<Product>> {
                return FirestoreMapper.mapResponsesToDomain(data)
            }

            override suspend fun createCall(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>> {
                return firestoreDataSource.getAccessoriesList()
            }
        }.asFlow()
    }

    override fun getDetailProduct(id: Int): Flow<Resource<Product>> {
        return object : FirestoreOnlyResource<Product, ProductFirestoreResponse>() {
            override fun loadFromNetwork(data: ProductFirestoreResponse): Flow<Product> {
                return FirestoreMapper.mapResponseToDomain(data)
            }

            override suspend fun createCall(): Flow<FirestoreResponse<ProductFirestoreResponse>> {
                return firestoreDataSource.getProductDetail(id)
            }
        }.asFlow()
    }

    override fun getSelectionProduct(): Flow<Resource<List<Product>>> {
        return object : FirestoreOnlyResource<List<Product>, List<ProductFirestoreResponse>>() {
            override fun loadFromNetwork(data: List<ProductFirestoreResponse>): Flow<List<Product>> {
                return FirestoreMapper.mapResponsesToDomain(data)
            }

            override suspend fun createCall(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>> {
                return  firestoreDataSource.getSelectionProducts()
            }

        }.asFlow()
    }

    override fun getNewProduct(): Flow<Resource<List<Product>>> {
        return object : FirestoreOnlyResource<List<Product>, List<ProductFirestoreResponse>>() {
            override fun loadFromNetwork(data: List<ProductFirestoreResponse>): Flow<List<Product>> {
                return FirestoreMapper.mapResponsesToDomain(data)
            }

            override suspend fun createCall(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>> {
                return  firestoreDataSource.getNewProducts()
            }

        }.asFlow()
    }

    override fun getSearchProducts(query: String): Flow<Resource<List<Product>>> {
        return object : FirestoreOnlyResource<List<Product>, List<ProductFirestoreResponse>>() {
            override fun loadFromNetwork(data: List<ProductFirestoreResponse>): Flow<List<Product>> {
                return FirestoreMapper.mapResponsesToDomain(data)
            }

            override suspend fun createCall(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>> {
                return firestoreDataSource.getSearchProducts(query)
            }
        }.asFlow()
    }

    override fun getAllDiscount(): Flow<Resource<List<String>>> {
        return object : NetworkOnlyResource<List<String>, List<String>>() {
            override fun loadFromNetwork(data: List<String>): Flow<List<String>> {
                return DataMapper.mapString(data)
            }

            override suspend fun createCall(): Flow<ApiResponse<List<String>>> {
                return remoteDataSource.getAllDiscount()
            }

        }.asFlow()
    }

    override fun getAllCategoryImage(): Flow<Resource<List<String>>> {
        return object : NetworkOnlyResource<List<String>, List<String>>() {
            override fun loadFromNetwork(data: List<String>): Flow<List<String>> {
                return DataMapper.mapString(data)
            }

            override suspend fun createCall(): Flow<ApiResponse<List<String>>> {
                return remoteDataSource.getAllCategoryImage()
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