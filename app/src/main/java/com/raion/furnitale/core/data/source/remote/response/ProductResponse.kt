package com.raion.furnitale.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ProductResponse (
    @field: SerializedName("id")
    val id: Int? = 0,

    @field: SerializedName("title")
    val title: String? = null,

    @field: SerializedName("sub_title")
    val subTitle: String? = null,

    @field: SerializedName("image_product")
    val imageProduct: String? = null,

    @field: SerializedName("image_seller")
    val imageSeller: String? = null,

    @field: SerializedName("category")
    val category: String? = null,

    @field: SerializedName("price")
    val price: String? = null,

    @field: SerializedName("store_name")
    val storeName: String? = null,

    @field: SerializedName("city")
    val city: String? = null,

    @field: SerializedName("description")
    val description: String? = null
)