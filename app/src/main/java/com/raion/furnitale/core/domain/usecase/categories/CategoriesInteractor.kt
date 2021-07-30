package com.raion.furnitale.core.domain.usecase.categories

import com.raion.furnitale.core.data.Resource
import com.raion.furnitale.core.domain.model.Product
import com.raion.furnitale.core.domain.repository.IProductRepository
import kotlinx.coroutines.flow.Flow

class CategoriesInteractor(private val repository: IProductRepository): CategoriesUseCase {
    override fun getLivingRoomList(): Flow<Resource<List<Product>>> {
        return repository.getLivingRoomList()
    }

    override fun getBedRoomList(): Flow<Resource<List<Product>>> {
        return repository.getBedRoomList()
    }

    override fun getKitchenList(): Flow<Resource<List<Product>>> {
        return repository.getKitchenList()
    }

    override fun getBathRoomList(): Flow<Resource<List<Product>>> {
        return repository.getBathRoomList()
    }

    override fun getOutdoorList(): Flow<Resource<List<Product>>> {
        return repository.getOutdoorList()
    }

    override fun getAccessoriesList(): Flow<Resource<List<Product>>> {
        return repository.getAccessoriesList()
    }
}