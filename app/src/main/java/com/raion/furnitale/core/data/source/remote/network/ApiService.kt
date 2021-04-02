package com.raion.furnitale.core.data.source.remote.network

import com.raion.furnitale.core.data.source.remote.response.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/{id}")
    suspend fun getDetailProduct (
        @Path("id") id: Int
    ): ProductResponse
}