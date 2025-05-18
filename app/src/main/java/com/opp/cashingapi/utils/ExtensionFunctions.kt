package com.opp.cashingapi.utils
import java.text.NumberFormat
import java.util.*
fun String?.orDefault(default: String=""): String{
    return this?:default
}

fun Double.toIndianLocaleCurrency(): String {
    val format = NumberFormat.getCurrencyInstance(Locale("en", "IN"))
    return format.format(this)
}