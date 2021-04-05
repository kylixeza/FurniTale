package com.raion.furnitale.core.domain.model

data class Product(
    val id: Int?,
    val userEmail: String?,
    val title: String?,
    val subTitle: String?,
    val imageProduct: String?,
    val imageSeller: String?,
    val category: String?,
    val price: String?,
    val storeName: String?,
    val city: String?,
    val description: String?,
    val totalStuffs: Int?
)
