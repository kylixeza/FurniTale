package com.raion.furnitale.core.data.source.firestore

import com.raion.furnitale.core.data.source.firestore.network.FirestoreClient
import com.raion.furnitale.core.data.source.firestore.network.FirestoreResponse
import com.raion.furnitale.core.data.source.firestore.response.ProductFirestoreResponse
import kotlinx.coroutines.flow.Flow

class FirestoreDataSource(private val firestoreClient: FirestoreClient) {

    suspend fun getLivingRoomList(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>> {
        return firestoreClient.getLivingRoomList()
    }

    suspend fun getBedroomList(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>> {
        return firestoreClient.getBedRoomList()
    }

    suspend fun getKitchenList(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>> {
        return firestoreClient.getKitchenList()
    }

    suspend fun getBathroomList(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>> {
        return firestoreClient.getBathroomList()
    }

    suspend fun getOutdoorList(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>> {
        return firestoreClient.getOutdoorList()
    }

    suspend fun getAccessoriesList(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>> {
        return firestoreClient.getAccessoriesList()
    }

    suspend fun getProductDetail(id: Int): Flow<FirestoreResponse<ProductFirestoreResponse>> {
        return firestoreClient.getProductDetail(id)
    }

    suspend fun getSelectionProducts(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>> {
        return firestoreClient.getSelectionProducts()
    }

    suspend fun getNewProducts(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>> {
        return firestoreClient.getNewProducts()
    }

    suspend fun getSearchProducts(query: String): Flow<FirestoreResponse<List<ProductFirestoreResponse>>> {
        return firestoreClient.getSearchProducts(query)
    }
}