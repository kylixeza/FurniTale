package com.raion.furnitale.core.di

import androidx.room.Room
import com.raion.furnitale.core.data.ProductRepository
import com.raion.furnitale.core.data.source.firestore.FirestoreDataSource
import com.raion.furnitale.core.data.source.firestore.network.FirestoreClient
import com.raion.furnitale.core.data.source.firestore.network.FirestorePlayground
import com.raion.furnitale.core.data.source.local.LocalDataSource
import com.raion.furnitale.core.data.source.local.room.ProductDatabase
import com.raion.furnitale.core.data.source.remote.RemoteDataSource
import com.raion.furnitale.core.data.source.remote.network.DummyApiService
import com.raion.furnitale.core.domain.repository.IProductRepository
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    factory {
        get<ProductDatabase>().productDao()
    }

    single {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("FurniTale".toCharArray())
        val factory = SupportFactory(passphrase)
        Room.databaseBuilder(
            androidContext(),
            ProductDatabase::class.java, "Product.db"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
}

val firestoreModule = module {
    single<FirestoreClient> {
        FirestorePlayground()
    }

}

val repositoryModule = module {
    single { DummyApiService() }
    single { RemoteDataSource(get()) }
    single { LocalDataSource(get()) }
    single { FirestoreDataSource(get()) }
    single<IProductRepository> {
        ProductRepository(
            get(),
            get(),
            get()
        )
    }
}