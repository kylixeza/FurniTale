package com.raion.furnitale.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.raion.furnitale.core.domain.usecase.search.SearchUseCase

class SearchViewModel(private val useCase: SearchUseCase) : ViewModel() {

    fun getSearchProducts(query: String) = useCase.getSearchProducts(query).asLiveData()
}