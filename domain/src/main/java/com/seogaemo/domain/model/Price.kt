package com.seogaemo.domain.model

data class Price(
    val originPrice: Int,
    val finalPrice: Int,
    val salesStatus: SalesStatus
)
