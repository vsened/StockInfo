package com.vsened.stockinfo.data.mapper

import com.vsened.stockinfo.data.local.CompanyListingEntity
import com.vsened.stockinfo.data.remote.dto.CompanyInfoDto
import com.vsened.stockinfo.domain.model.CompanyInfo
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

fun CompanyInfoDto.toCompanyInfo(): CompanyInfo {
    return CompanyInfo(
        symbol = symbol ?: "",
        description = description ?: "",
        name = name ?: "",
        country = country ?: "",
        industry = industry ?: ""
    )
}