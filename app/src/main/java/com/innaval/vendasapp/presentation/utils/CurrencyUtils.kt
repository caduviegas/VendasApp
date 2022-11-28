package com.innaval.vendasapp.presentation.utils

import java.text.NumberFormat
import java.util.*

fun Double.formatCurrencyBR(): String {
    val numberString = String.format("%.2f", this)
    val brlSymbol = "R$"
    val formatted = numberString
        .reversed()
        .chunked(3)
        .joinToString(",")
        .reversed()
        .replace(",", ".")
        .replace("..", ",")
    return "$brlSymbol $formatted"
}