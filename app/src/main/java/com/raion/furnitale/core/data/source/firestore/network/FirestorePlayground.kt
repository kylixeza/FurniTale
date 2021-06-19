package com.raion.furnitale.core.data.source.firestore.network

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.kiwimob.firestore.coroutines.await
import com.raion.furnitale.core.data.source.firestore.response.ProductFirestoreResponse
import com.raion.furnitale.core.utils.CategoryType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.*

class FirestorePlayground: FirestoreClient {

    private val fireStore: FirebaseFirestore = Firebase.firestore
    private val productsRef = fireStore.collection("products")

    override suspend fun getLivingRoomList(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>> = flow {
        try {
            val listLivingRoom = productsRef
                .whereEqualTo("category", CategoryType.LIVINGROOM.desc)
                .get()
                .await()
                .toObjects(ProductFirestoreResponse::class.java) as List<ProductFirestoreResponse>

            Log.d("Firestore Playground", listLivingRoom.toString())

            if (listLivingRoom.isNullOrEmpty()) {
                emit(FirestoreResponse.Error(null))
            } else {
                emit(FirestoreResponse.Success(listLivingRoom))
            }
        } catch (e: Exception) {
            emit(FirestoreResponse.Error(e.toString()))
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun getBedRoomList(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>> = flow {
        try {
            val listBedroom = productsRef
                .whereEqualTo("category", CategoryType.BEDROOM.desc)
                .get()
                .await()
                .toObjects(ProductFirestoreResponse::class.java)  as List<ProductFirestoreResponse>

            if (listBedroom.isNullOrEmpty()) {
                emit(FirestoreResponse.Error(null))
            } else {
                emit(FirestoreResponse.Success(listBedroom))
            }

        }catch (e: Exception) {
            emit(FirestoreResponse.Error(e.toString()))
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun getKitchenList(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>> = flow {
        try {
            val listKitchenList = productsRef
                .whereEqualTo("category", CategoryType.KITCHEN.desc)
                .get()
                .await()
                .toObjects(ProductFirestoreResponse::class.java) as List<ProductFirestoreResponse>

            if (listKitchenList.isNullOrEmpty()) {
                emit(FirestoreResponse.Error(null))
            } else {
                emit(FirestoreResponse.Success(listKitchenList))
            }
        } catch (e: Exception) {
            emit(FirestoreResponse.Error(e.toString()))
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun getBathroomList(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>>  = flow {
        try {
            val listBathroom = productsRef
                .whereEqualTo("category", CategoryType.BATHROOM.desc)
                .get()
                .await()
                .toObjects(ProductFirestoreResponse::class.java) as List<ProductFirestoreResponse>

            if (listBathroom.isNullOrEmpty()) {
                emit(FirestoreResponse.Error(null))
            } else {
                emit(FirestoreResponse.Success(listBathroom))
            }
        } catch (e: Exception) {
            emit(FirestoreResponse.Error(e.toString()))
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun getOutdoorList(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>>  = flow {
        try {
            val listOutdoor = productsRef
                .whereEqualTo("category", CategoryType.OUTDOOR.desc)
                .get()
                .await()
                .toObjects(ProductFirestoreResponse::class.java) as List<ProductFirestoreResponse>

            if (listOutdoor.isNullOrEmpty()) {
                emit(FirestoreResponse.Error(null))
            } else {
                emit(FirestoreResponse.Success(listOutdoor))
            }
        } catch (e: Exception) {
            emit(FirestoreResponse.Error(e.toString()))
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun getAccessoriesList(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>> = flow {
        try {
            val listAccessories = productsRef
                .whereEqualTo("category", CategoryType.ACCESSORIES.desc)
                .get()
                .await()
                .toObjects(ProductFirestoreResponse::class.java) as List<ProductFirestoreResponse>

            if (listAccessories.isNullOrEmpty()) {
                emit(FirestoreResponse.Error(null))
            } else {
                emit(FirestoreResponse.Success(listAccessories))
            }

        } catch (e: Exception) {
            emit(FirestoreResponse.Error(e.toString()))
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun getProductDetail(id: Int): Flow<FirestoreResponse<ProductFirestoreResponse>> = flow {
        try {
            val selectedProduct = productsRef
                .whereEqualTo("id", id)
                .get()
                .await()
                .toObjects(ProductFirestoreResponse::class.java)

            emit(FirestoreResponse.Success(selectedProduct[0]))

        } catch (e: Exception) {
            emit(FirestoreResponse.Error(e.toString()))
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun getSelectionProducts(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>> = flow {
        try {
            val selectionList = productsRef
                .whereEqualTo("id", listOf(2, 4, 6, 10, 16))
                .get()
                .await()
                .toObjects(ProductFirestoreResponse::class.java)

            emit(FirestoreResponse.Success(selectionList))
        } catch (e: Exception) {
            emit(FirestoreResponse.Error(e.toString()))
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun getNewProducts(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>> = flow {
        try {
            val newList = productsRef
                .whereEqualTo("id", 6)
                .whereEqualTo("id", 9)
                .get()
                .await()
                .toObjects(ProductFirestoreResponse::class.java)

            emit(FirestoreResponse.Success(newList))
        } catch (e: Exception) {
            emit(FirestoreResponse.Error(e.toString()))
        }
    }.flowOn(Dispatchers.IO)

    @InternalCoroutinesApi
    override suspend fun getSearchProducts(query: String): Flow<FirestoreResponse<List<ProductFirestoreResponse>>> = flow {
        val queryList = ArrayList<ProductFirestoreResponse>()
        try {
            val resultList = productsRef
                .get()
                .await()
                .toObjects(ProductFirestoreResponse::class.java)

            if (resultList.isNullOrEmpty())
                emit(FirestoreResponse.Error(null))
            else {
                resultList.forEach {
                    if (it.title?.contains(query, true) == true) {
                        queryList.add(it)
                    }
                }
                emit(FirestoreResponse.Success(queryList))
            }

        } catch (e: Exception) {
            emit(FirestoreResponse.Error(e.toString()))
        }
    }.flowOn(Dispatchers.IO)
}