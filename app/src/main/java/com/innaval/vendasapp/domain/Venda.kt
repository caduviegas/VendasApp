package com.innaval.vendasapp.domain

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
@Entity
data class Venda(
    @SerializedName("id")
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @SerializedName("data_criacao")
    val dataCriacao: Date,
    @SerializedName("descricao")
    val descricao: String,
    @SerializedName("nome_cliente")
    val nomeCliente: String
):Parcelable