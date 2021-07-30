package com.raion.furnitale.core.data.source.firestore.network

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.kiwimob.firestore.coroutines.await
import com.raion.furnitale.core.data.source.firestore.response.ProductFirestoreResponse
import com.raion.furnitale.core.utils.CategoryType
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class FirestorePlayground: FirestoreClient {

    private val fireStore: FirebaseFirestore = Firebase.firestore
    private val productsRef = fireStore.collection("products")

    override suspend fun getLivingRoomList(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>> = flow {
        try {
            var listLivingRoom: List<ProductFirestoreResponse> = ArrayList()

            CoroutineScope(Dispatchers.IO).launch {
                listLivingRoom = productsRef
                    .whereEqualTo("category", CategoryType.LIVINGROOM.desc)
                    .get()
                    .await()
                    .toObjects(ProductFirestoreResponse::class.java)
            }.join()

            if (listLivingRoom.isNullOrEmpty())
                emit(FirestoreResponse.Error(null))
            else
                emit(FirestoreResponse.Success(listLivingRoom))
        } catch (e: Exception) {
            emit(FirestoreResponse.Error(e.toString()))
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun getBedRoomList(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>> = flow {
        try {
            var listBedroom: List<ProductFirestoreResponse> = ArrayList()

            CoroutineScope(Dispatchers.IO).launch {
                listBedroom = productsRef
                .whereEqualTo("category", CategoryType.BEDROOM.desc)
                .get()
                .await()
                .toObjects(ProductFirestoreResponse::class.java)
            }.join()

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
            var listKitchenList: List<ProductFirestoreResponse> = ArrayList()

            CoroutineScope(Dispatchers.IO).launch {
                listKitchenList = productsRef
                    .whereEqualTo("category", CategoryType.KITCHEN.desc)
                    .get()
                    .await()
                    .toObjects(ProductFirestoreResponse::class.java)
            }.join()

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
            var listBathroom: List<ProductFirestoreResponse> = ArrayList()

            CoroutineScope(Dispatchers.IO).launch {
                listBathroom = productsRef
                    .whereEqualTo("category", CategoryType.BATHROOM.desc)
                    .get()
                    .await()
                    .toObjects(ProductFirestoreResponse::class.java)
            }.join()

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
            var listOutdoor: List<ProductFirestoreResponse> = ArrayList()

            CoroutineScope(Dispatchers.IO).launch {
                listOutdoor = productsRef
                    .whereEqualTo("category", CategoryType.OUTDOOR.desc)
                    .get()
                    .await()
                    .toObjects(ProductFirestoreResponse::class.java)
            }.join()

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
            var listAccessories: List<ProductFirestoreResponse> = ArrayList()

            CoroutineScope(Dispatchers.IO).launch {
                listAccessories = productsRef
                    .whereEqualTo("category", CategoryType.ACCESSORIES.desc)
                    .get()
                    .await()
                    .toObjects(ProductFirestoreResponse::class.java)
            }.join()

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
            var selectedProduct: List<ProductFirestoreResponse> = ArrayList()

            CoroutineScope(Dispatchers.IO).launch {
                selectedProduct = productsRef
                    .whereEqualTo("id", id)
                    .get()
                    .await()
                    .toObjects(ProductFirestoreResponse::class.java)
            }
                .join()

            emit(FirestoreResponse.Success(selectedProduct[0]))

        } catch (e: Exception) {
            emit(FirestoreResponse.Error(e.toString()))
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun getSelectionProducts(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>> = flow {
        try {
            var selectionList: List<ProductFirestoreResponse> = ArrayList()

            CoroutineScope(Dispatchers.IO).launch {
                selectionList = productsRef
                    .whereIn("id", listOf(2, 4, 6, 10, 16))
                    .get()
                    .await()
                    .toObjects(ProductFirestoreResponse::class.java)
            }.join()

            emit(FirestoreResponse.Success(selectionList))
        } catch (e: Exception) {
            emit(FirestoreResponse.Error(e.toString()))
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun getNewProducts(): Flow<FirestoreResponse<List<ProductFirestoreResponse>>> = flow {
        try {
            var newList: List<ProductFirestoreResponse> = ArrayList()

            CoroutineScope(Dispatchers.IO).launch {
                newList = productsRef
                    .whereEqualTo("id", 6)
                    .get()
                    .await()
                    .toObjects(ProductFirestoreResponse::class.java)
            }.join()

            emit(FirestoreResponse.Success(newList))
        } catch (e: Exception) {
            emit(FirestoreResponse.Error(e.toString()))
        }
    }.flowOn(Dispatchers.IO)


    override suspend fun getSearchProducts(query: String): Flow<FirestoreResponse<List<ProductFirestoreResponse>>> = flow {

        try {
            var queryList: List<ProductFirestoreResponse> = ArrayList()
            val resultList = ArrayList<ProductFirestoreResponse>()

            CoroutineScope(Dispatchers.IO).launch {
                queryList = productsRef
                    .get()
                    .await()
                    .toObjects(ProductFirestoreResponse::class.java)
            }.join()

            queryList.forEach {
                if (it.title?.contains(query, true)!!)
                    resultList.add(it)
            }

            if (resultList.isNullOrEmpty())
                emit(FirestoreResponse.Error(null))
            else
                emit(FirestoreResponse.Success(resultList))

        } catch (e: Exception) {
            emit(FirestoreResponse.Error(e.toString()))
        }
    }.flowOn(Dispatchers.IO)
}