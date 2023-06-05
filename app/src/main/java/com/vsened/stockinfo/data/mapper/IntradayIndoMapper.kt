package com.vsened.stockinfo.data.mapper

import java.util.Locale
import com.vsened.stockinfo.data.remote.dto.IntradayInfoDto
import com.vsened.stockinfo.domain.model.IntradayInfo
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun IntradayInfoDto.toIntradayInfo(): IntradayInfo {
    val pattern = "dd-MM-yyyy HH:mm:ss"
    val formatter = DateTimeFormatter.ofPattern(pattern, Locale.getDefault())
    val localDateTime = LocalDateTime.parse(timestamp, formatter)
    return IntradayInfo(
        date = localDateTime,
        close = close
    )
}