package com.vsened.stockinfo.data.repository

import com.opencsv.CSVReader
import com.vsened.stockinfo.data.local.StockDatabase
import com.vsened.stockinfo.data.mapper.toCompanyListing
import com.vsened.stockinfo.data.remote.StockApi
import com.vsened.stockinfo.domain.model.CompanyListing
import com.vsened.stockinfo.domain.repository.StockRepository
import com.vsened.stockinfo.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.io.InputStreamReader
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StockRepositoryImpl @Inject constructor(
    val api: StockApi,
    val db: StockDatabase
): StockRepository {

    private val dao = db.dao

    override suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>> {
        return flow {
            emit(Resource.Loading(isLoading = true))
            val localListings = dao.searchCompanyListing(query)
            emit(Resource.Success(
                data = localListings.map { it.toCompanyListing() }
            ))
            val isDbEmpty = localListings.isEmpty() && query.isBlank()
            val shouldJustLoadFromCache = !isDbEmpty && !fetchFromRemote
            if (shouldJustLoadFromCache) {
                emit(Resource.Loading(false))
                return@flow
            }
            val removeListings = try {
                val response = api.getListings()
                TODO("Get data from csv file!")
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error(message = e.message ?: "IOException"))
            }catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error(message = e.message ?: "HttpException"))
            }
        }
    }
}