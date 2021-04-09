package com.raion.furnitale.core.domain.model

data class Product(
    var key: String?,
    val id: Int?,
    var userEmail: String?,
    val title: String?,
    val subTitle: String?,
    val imageProduct: String?,
    val imageSeller: String?,
    val category: String?,
    val price: String?,
    val realPrice: Int?,
    val storeName: String?,
    val city: String?,
    val description: String?,
    var totalStuffs: Int?
)
