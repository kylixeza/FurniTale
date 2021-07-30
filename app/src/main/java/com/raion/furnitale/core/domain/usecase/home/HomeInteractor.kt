package com.raion.furnitale.core.domain.usecase.home

import com.raion.furnitale.core.data.Resource
import com.raion.furnitale.core.domain.model.Product
import com.raion.furnitale.core.domain.repository.IProductRepository
import kotlinx.coroutines.flow.Flow

class HomeInteractor(private val repository: IProductRepository): HomeUseCase {

    override fun getSelectionProduct(): Flow<Resource<List<Product>>> {
        return repository.getSelectionProduct()
    }

    override fun getNewProduct(): Flow<Resource<List<Product>>> {
        return repository.getNewProduct()
    }

    override fun getAllDiscount(): Flow<Resource<List<String>>> {
        return repository.getAllDiscount()
    }

    override fun getAllCategoryImage(): Flow<Resource<List<String>>> {
        return repository.getAllCategoryImage()
    }
}