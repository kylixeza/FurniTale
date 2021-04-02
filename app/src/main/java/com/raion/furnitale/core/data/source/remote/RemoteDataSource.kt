package com.raion.furnitale.core.data.source.remote

import com.raion.furnitale.core.data.source.remote.network.ApiResponse
import com.raion.furnitale.core.data.source.remote.network.ApiService
import com.raion.furnitale.core.data.source.remote.response.ProductResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception

class RemoteDataSource(private val apiService: ApiService) {

    fun getDetailProduct(id: Int): Flow<ApiResponse<ProductResponse>> =
        flow {
            try {
                val productDetail = apiService.getDetailProduct(id)
                emit(ApiResponse.Success(productDetail))
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
}