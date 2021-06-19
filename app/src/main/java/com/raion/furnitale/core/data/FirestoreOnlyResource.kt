package com.raion.furnitale.core.data

import com.raion.furnitale.core.data.source.firestore.network.FirestoreResponse
import com.raion.furnitale.core.data.source.remote.network.ApiResponse
import kotlinx.coroutines.flow.*

abstract class FirestoreOnlyResource<ResultType, RequestType> {

    private val result: Flow<Resource<ResultType>> = flow {
        emit(Resource.Loading())
        when (val apiResponse = createCall().first()) {
            is FirestoreResponse.Success -> {
                emitAll(loadFromNetwork(apiResponse.data).map {
                    Resource.Success(it)
                })
            }

            is FirestoreResponse.Error -> {
                emit(Resource.Error<ResultType>(apiResponse.errorMessage))
            }
        }
    }

    protected abstract fun loadFromNetwork(data: RequestType): Flow<ResultType>

    protected abstract suspend fun createCall(): Flow<FirestoreResponse<RequestType>>

    fun asFlow(): Flow<Resource<ResultType>> = result
}