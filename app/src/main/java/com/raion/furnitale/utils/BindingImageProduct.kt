package com.raion.furnitale.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("product")
fun product(imageView: ImageView, product: String) {
    Glide.with(imageView)
        .load(product)
        .into(imageView)
}