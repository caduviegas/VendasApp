package com.innaval.vendasapp.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class Venda(
    @SerializedName("id")
    val id: Int,
    @SerializedName("data_criacao")
    val dataCriacao: Date,
    @SerializedName("descricao")
    val descricao: String
):Parcelable