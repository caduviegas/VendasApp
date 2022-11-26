package com.innaval.vendasapp.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Produto(
    @SerializedName("id")
    val id: Long,
    @SerializedName("venda_id")
    val vendaId:Long,
    @SerializedName("quantidade")
    val quantidade: Double,
    @SerializedName("preco")
    val preco: Double,
    @SerializedName("unidade")
    val unidade: String,
    @SerializedName("nome")
    val nome: String
): Parcelable
