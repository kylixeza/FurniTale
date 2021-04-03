package com.raion.furnitale.core.di

import com.raion.furnitale.BuildConfig
import com.raion.furnitale.core.data.ProductRepository
import com.raion.furnitale.core.data.source.remote.RemoteDataSource
import com.raion.furnitale.core.data.source.remote.network.DummyApiService
import com.raion.furnitale.core.domain.repository.IProductRepository
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val BASE_URL = BuildConfig.BASE_URL

val databaseModule = module {

}


val repositoryModule = module {
    factory { DummyApiService() }
    single { RemoteDataSource(get()) }
    single<IProductRepository> {
        ProductRepository(
            get()
        )
    }
}