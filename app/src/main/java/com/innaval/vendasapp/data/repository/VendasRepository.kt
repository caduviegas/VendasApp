package com.innaval.vendasapp.data.repository

import com.innaval.vendasapp.domain.Venda

interface VendasRepository {

    suspend fun salvarVendas()

    suspend fun novaVenda(): Venda

   suspend fun listarVendas():List<Venda>



}