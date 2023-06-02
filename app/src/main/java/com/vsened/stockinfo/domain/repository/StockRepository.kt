package com.vsened.stockinfo.domain.repository

import com.vsened.stockinfo.domain.model.CompanyListing
import com.vsened.stockinfo.util.Resource
import kotlinx.coroutines.flow.Flow

interface StockRepository {

    suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>>
}