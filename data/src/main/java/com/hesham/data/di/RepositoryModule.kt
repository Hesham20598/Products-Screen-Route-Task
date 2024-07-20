package com.hesham.data.di

import com.hesham.data.repository.ProductsRepositotyImpl
import com.hesham.domain.repository.ProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideProductsRepository(impl: ProductsRepositotyImpl): ProductsRepository {
        return impl
    }

}