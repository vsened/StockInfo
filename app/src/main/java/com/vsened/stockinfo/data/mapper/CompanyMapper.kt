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