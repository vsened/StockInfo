package com.vsened.stockinfo.presentation.company_listings

import com.vsened.stockinfo.domain.model.CompanyListing

data class CompanyListingsState(
    val companies: List<CompanyListing> = listOf(CompanyListing("null", "null", "null")),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val searchQuery: String = ""
)
