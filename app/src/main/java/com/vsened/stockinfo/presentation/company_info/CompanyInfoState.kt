package com.vsened.stockinfo.presentation.company_info

import com.vsened.stockinfo.domain.model.CompanyInfo
import com.vsened.stockinfo.domain.model.IntradayInfo

data class CompanyInfoState(
    val stockInfos: List<IntradayInfo> = emptyList(),
    val company: CompanyInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
