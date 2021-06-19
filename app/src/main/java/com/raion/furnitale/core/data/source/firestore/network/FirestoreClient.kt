package com.raion.furnitale.core.data.source.firestore.network

import com.raion.furnitale.core.data.source.firestore.response.ProductFirestoreResponse
import kotlinx.coroutines.flow.Flow

interface FirestoreClient {
    suspend fun getLivingRoomList(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>>
    suspend fun getBedRoomList(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>>
    suspend fun getKitchenList(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>>
    suspend fun getBathroomList(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>>
    suspend fun getOutdoorList(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>>
    suspend fun getAccessoriesList(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>>
    suspend fun getProductDetail(id: Int): Flow<FirestoreResponse<ProductFirestoreResponse>>

    suspend fun getSelectionProducts(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>>
    suspend fun getNewProducts(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>>
    suspend fun getSearchProducts(query: String): Flow<FirestoreResponse<List<ProductFirestoreResponse>>>
}