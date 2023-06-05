package com.vsened.stockinfo.data.mapper

import com.vsened.stockinfo.data.local.CompanyListingEntity
import com.vsened.stockinfo.domain.model.CompanyListing

fun CompanyListingEntity.toCompanyListing(): CompanyListing {
    return CompanyListing(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}

fun CompanyListing.toCompanyListingEntity(): CompanyListingEntity {
    return CompanyListingEntity(
        name = name,
        symbol = symbol,
        exchange =  exchange
    )
}

fun List<CompanyListingEntity>.toCompanyListingList(): List<CompanyListing> {
    val result = ArrayList<CompanyListing>()
    for (i in indices) {
        result.add(get(i).toCompanyListing())
    }
    return result
}