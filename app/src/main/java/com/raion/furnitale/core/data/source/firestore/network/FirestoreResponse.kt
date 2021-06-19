package com.raion.furnitale.core.data.source.firestore.network

sealed class FirestoreResponse<out T> {
    data class Success<out T> (val data: T): FirestoreResponse<T>()
    data class Error(val errorMessage: String?): FirestoreResponse<Nothing>()
}