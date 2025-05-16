package com.opp.cashingapi.di

import com.opp.cashingapi.data.api.ProductsApi
import com.opp.cashingapi.data.repositoryimpl.ProductRepositoryImpl
import com.opp.cashingapi.domain.ProductRepository
import com.opp.cashingapi.domain.usecase.GetProductsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ProductModule {
    @Provides
    fun provideProductRepository(api: ProductsApi): ProductRepository =
        ProductRepositoryImpl(api)

    @Provides
    fun provideGetProductsUseCase(repository: ProductRepository): GetProductsUseCase =
        GetProductsUseCase(repository)

}