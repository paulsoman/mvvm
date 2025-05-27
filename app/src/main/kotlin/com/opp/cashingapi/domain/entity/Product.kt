package com.opp.cashingapi.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val imageUrl: String,
    val description: String
):Parcelable
