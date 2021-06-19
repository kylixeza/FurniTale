package com.raion.furnitale.utils

import android.view.View

interface ShowState<BindingClass> {

    fun onResourceSuccess(binding: BindingClass?)
    fun onResourceFailed(binding: BindingClass?, message: String?)
    fun onResourceLoading(binding: BindingClass?)

    val visible get() = View.VISIBLE
    val gone get() = View.GONE
}