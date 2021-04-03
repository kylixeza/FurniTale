package com.raion.furnitale.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ProductResponse (
    @SerializedName("id")
    val id: Int? = 0,

    @SerializedName("title")
    val title: String? = null,

    @SerializedName("sub_title")
    val subTitle: String? = null,

    @SerializedName("image_product")
    val imageProduct: String? = null,

    @SerializedName("image_seller")
    val imageSeller: String? = null,

    @SerializedName("category")
    val category: String? = null,

    @SerializedName("price")
    val price: String? = null,

    @SerializedName("store_name")
    val storeName: String? = null,

    @SerializedName("city")
    val city: String? = null,

    @SerializedName("description")
    val description: String? = null
)