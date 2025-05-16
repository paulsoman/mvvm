package com.opp.cashingapi.data.dto

data class ReviewDTO(
    val comment: String,
    val date: String,
    val rating: Int,
    val reviewerEmail: String,
    val reviewerName: String
)