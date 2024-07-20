package com.hesham.data.di

import com.hesham.data.api.ProductListService
import com.hesham.data.dataSources.ProductsOnlineDataSourceImpl
import com.hesham.domain.repository.NetworkHandler
import com.hesham.domain.repository.ProductsOnlineDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideProductsOnlineDataSource(service: ProductListService): ProductsOnlineDataSource {
        return ProductsOnlineDataSourceImpl(service)
    }

    @Provides
    @Singleton
    fun provideNetworkHandler(): NetworkHandler {
        return object : NetworkHandler {
            override fun isOnline(): Boolean {
                return true
            }
        }
    }


}