package com.innaval.vendasapp.presentation.utils

import java.text.SimpleDateFormat
import java.util.Date

//Função Extension
fun Date.formatDateBR():String{
    val pattern = "dd/MM/yyyy"
    val dateFormat = SimpleDateFormat(pattern)
    return dateFormat.format(this)
}