package com.raion.furnitale.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.raion.furnitale.R

@BindingAdapter("seller")
fun seller(imageView: ImageView, seller: String) {
    Glide.with(imageView)
        .load(seller)
        .apply(RequestOptions.circleCropTransform()).placeholder(R.drawable.ic_account)
        .into(imageView)
}