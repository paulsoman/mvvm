package com.opp.cashingapi.utils

fun String?.orDefault(default: String=""): String{
    return this?:default
}