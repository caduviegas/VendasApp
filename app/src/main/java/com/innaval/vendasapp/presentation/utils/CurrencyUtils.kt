package com.innaval.vendasapp.presentation.utils

import java.text.NumberFormat
import java.util.*

fun Double.formatCurrencyBR():String{
    val format: NumberFormat = NumberFormat.getCurrencyInstance()
    format.maximumFractionDigits = 0
    format.currency = Currency.getInstance("BRL")
    return format.format(this)
}