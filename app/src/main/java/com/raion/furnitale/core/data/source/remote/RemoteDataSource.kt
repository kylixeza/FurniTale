package com.raion.furnitale.core.data.source.remote

import com.raion.furnitale.core.data.source.remote.network.ApiResponse
import com.raion.furnitale.core.data.source.remote.network.DummyApiService
import com.raion.furnitale.core.data.source.remote.response.ProductResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: DummyApiService) {

    fun getLivingRoomList(): Flow<ApiResponse<List<ProductResponse>>> =
        flow {
            val livingRoomArr = apiService.getLivingRoomList()
            emit(ApiResponse.Success(livingRoomArr))
        }.flowOn(Dispatchers.IO)

    fun getBedRoomList(): Flow<ApiResponse<List<ProductResponse>>> =
        flow {
            val bedRoomArr = apiService.getBedRoomList()
            emit(ApiResponse.Success(bedRoomArr))
        }.flowOn(Dispatchers.IO)

    fun getKitchenList(): Flow<ApiResponse<List<ProductResponse>>> =
        flow {
            val kitchenArr = apiService.getKitchenList()
            emit(ApiResponse.Success(kitchenArr))
        }.flowOn(Dispatchers.IO)

    fun getBathRoomList(): Flow<ApiResponse<List<ProductResponse>>> =
        flow {
            val bathRoomArr = apiService.getBathroomList()
            emit(ApiResponse.Success(bathRoomArr))
        }.flowOn(Dispatchers.IO)

    fun getOutdoorList(): Flow<ApiResponse<List<ProductResponse>>> =
        flow {
            val outdoorArr = apiService.getOutdoorList()
            emit(ApiResponse.Success(outdoorArr))
        }.flowOn(Dispatchers.IO)

    fun getAccessoriesList(): Flow<ApiResponse<List<ProductResponse>>> =
        flow {
            val accessoriesArr = apiService.getAccessoriesList()
            emit(ApiResponse.Success(accessoriesArr))
        }.flowOn(Dispatchers.IO)

    fun getDetailProduct(id: Int): Flow<ApiResponse<ProductResponse>> =
        flow {
            val productDetail = apiService.getProductDetail(id)
            emit(ApiResponse.Success(productDetail))
        }.flowOn(Dispatchers.IO)

    fun getSelectionProduct(): Flow<ApiResponse<List<ProductResponse>>> =
        flow {
            val selectionArr = apiService.getProductSelection()
            emit(ApiResponse.Success(selectionArr))
        }.flowOn(Dispatchers.IO)

    fun getNewProduct(): Flow<ApiResponse<List<ProductResponse>>> =
        flow {
            val newArr = apiService.getNewProduct()
            emit(ApiResponse.Success(newArr))
        }.flowOn(Dispatchers.IO)

    fun getSearchProducts(query: String): Flow<ApiResponse<List<ProductResponse>>> =
        flow {
            val searchArr = apiService.getSearchProducts(query)
            emit(ApiResponse.Success(searchArr))
        }.flowOn(Dispatchers.IO)

    fun getAllDiscount(): Flow<ApiResponse<List<String>>> =
        flow {
            val discountArr = apiService.getAllDiscount()
            emit(ApiResponse.Success(discountArr))
        }.flowOn(Dispatchers.IO)

    fun getAllCategoryImage(): Flow<ApiResponse<List<String>>> =
        flow {
            val categoryImageArr = apiService.getAllCategoryImage()
            emit(ApiResponse.Success(categoryImageArr))
        }.flowOn(Dispatchers.IO)
}