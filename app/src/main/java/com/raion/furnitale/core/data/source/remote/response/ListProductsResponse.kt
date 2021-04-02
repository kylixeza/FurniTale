package com.raion.furnitale.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListProductsResponse (
    @field: SerializedName("products")
    val products: List<ProductResponse>
)