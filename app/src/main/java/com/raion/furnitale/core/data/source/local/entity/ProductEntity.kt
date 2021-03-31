package com.raion.furnitale.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProductEntity(

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int?,

    @ColumnInfo(name = "user_email")
    val userEmail: String?,

    @ColumnInfo(name = "title")
    val title: String?,

    @ColumnInfo(name = "sub_title")
    val subTitle: String?,

    @ColumnInfo(name = "category")
    val category: String?,

    @ColumnInfo(name = "price")
    val price: String?,

    @ColumnInfo(name = "store_name")
    val storeName: String?,

    @ColumnInfo(name = "city")
    val city: String?,

    @ColumnInfo(name = "description")
    val description: String?
)
