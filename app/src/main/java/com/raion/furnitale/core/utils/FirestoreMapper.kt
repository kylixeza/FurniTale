package com.raion.furnitale.core.utils

import com.raion.furnitale.core.data.source.firestore.response.ProductFirestoreResponse
import com.raion.furnitale.core.domain.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

object FirestoreMapper {
    fun mapResponsesToDomain(input: List<ProductFirestoreResponse>): Flow<List<Product>> {
        val domainArray = ArrayList<Product>()

        input.map { response ->
            val product = Product(
                key = "",
                id = response.id,
                userEmail = null,
                title = response.title,
                subTitle = response.subTitle,
                imageProduct = response.imageProduct,
                imageSeller = response.imageSeller,
                category = response.category,
                price = response.price,
                realPrice = response.realPrice,
                storeName = response.storeName,
                city = response.city,
                description = response.description,
                0
            )
            domainArray.add(product)
        }
        return flowOf(domainArray)
    }

    fun mapResponseToDomain(input: ProductFirestoreResponse): Flow<Product> = flowOf(
        Product(
            key = "",
            id = input.id,
            userEmail = null,
            title = input.title,
            subTitle = input.subTitle,
            imageProduct = input.imageProduct,
            imageSeller = input.imageSeller,
            category = input.category,
            price = input.price,
            realPrice = input.realPrice,
            storeName = input.storeName,
            city = input.city,
            description = input.description,
            0
        )
    )
}