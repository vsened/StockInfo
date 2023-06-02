package com.vsened.stockinfo.di

import com.vsened.stockinfo.data.csv.CSVParser
import com.vsened.stockinfo.data.csv.CompanyListingsParser
import com.vsened.stockinfo.data.repository.StockRepositoryImpl
import com.vsened.stockinfo.domain.model.CompanyListing
import com.vsened.stockinfo.domain.repository.StockRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCompanyListingsParser(
        companyListingsParser: CompanyListingsParser
    ): CSVParser<CompanyListing>

    @Binds
    @Singleton
    abstract fun bindStockRepository(
        stockRepositoryImpl: StockRepositoryImpl
    ): StockRepository
}