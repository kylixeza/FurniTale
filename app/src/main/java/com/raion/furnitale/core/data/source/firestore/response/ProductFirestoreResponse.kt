package com.raion.furnitale.core.data.source.firestore.response

data class ProductFirestoreResponse(
    val key: String? = "",
    val id: Int? = 0,
    val title: String? = null,
    val subTitle: String? = null,
    val imageProduct: String? = null,
    val imageSeller: String? = null,
    val category: String? = null,
    val price: String? = null,
    val realPrice: Int? = 0,
    val storeName: String? = null,
    val city: String? = null,
    val description: String? = null
) {
    constructor(): this(
        "",
        0,
        "",
        "",
        "",
        "",
        "",
        "",
        0,
        "",
        "",
        ""
    )
}
