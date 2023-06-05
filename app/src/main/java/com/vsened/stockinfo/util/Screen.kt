package com.vsened.stockinfo.util

sealed class Screen(val route: String) {
    object CompanyListings: Screen("company_listing")
}