package com.raion.furnitale.core.utils

import com.raion.furnitale.core.data.source.local.entity.ProductEntity
import com.raion.furnitale.core.data.source.remote.response.ProductResponse
import com.raion.furnitale.core.domain.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

object DataMapper {

    fun mapResponsesToDomain(input: List<ProductResponse>): Flow<List<Product>> {
        val domainArray = ArrayList<Product>()
        input.map { response ->
            val product =  Product(
                 key = null,
                id = response.id,
                userEmail = null,
                title = response.title,
                subTitle = response.subTitle,
                imageProduct = response.imageProduct,
                imageSeller = response.imageSeller,
                category = response.category,
                price = response.price,
                storeName = response.storeName,
                city = response.city,
                description = response.description,
                0
            )
            domainArray.add(product)
        }
        return flowOf(domainArray)
    }

    fun mapResponseToDomain(input: ProductResponse): Flow<Product> = flowOf (
            Product(
                key = null,
                id = input.id,
                userEmail = null,
                title = input.title,
                subTitle = input.subTitle,
                imageProduct = input.imageProduct,
                imageSeller = input.imageSeller,
                category = input.category,
                price = input.price,
                storeName = input.storeName,
                city = input.city,
                description = input.description,
                0
            )
        )

    fun mapEntitiesToDomain(input: List<ProductEntity>): List<Product> =
        input.map { entity ->
            Product(
                key = entity.key,
                id = entity.id,
                userEmail = entity.userEmail,
                title = entity.title,
                subTitle = entity.subTitle,
                imageProduct = entity.imageProduct,
                imageSeller = entity.imageSeller,
                category = entity.category,
                price = entity.price,
                storeName = entity.storeName,
                city = entity.city,
                description = entity.description,
                totalStuffs = entity.totalStuffs!!
            )
        }

    fun mapEntityToDomain(input: ProductEntity): Product =
        Product(
            key =  input.key,
            id = input.id,
            userEmail = input.userEmail,
            title = input.title,
            subTitle = input.subTitle,
            imageProduct = input.imageProduct,
            imageSeller = input.imageSeller,
            category = input.category,
            price = input.price,
            storeName = input.storeName,
            city = input.city,
            description = input.description,
            totalStuffs = input.totalStuffs!!
        )

    fun mapDomainToEntity(input: Product): ProductEntity =
        ProductEntity(
            key = input.key!!,
            id = input.id,
            userEmail = input.userEmail.toString(),
            title = input.title,
            subTitle = input.subTitle,
            imageProduct = input.imageProduct,
            imageSeller = input.imageSeller,
            category = input.category,
            price = input.price,
            storeName = input.storeName,
            city = input.city,
            description = input.description,
            totalStuffs = input.totalStuffs
        )
}