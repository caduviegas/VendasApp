package com.innaval.vendasapp.data.repository

import com.innaval.vendasapp.domain.Venda

interface VendasRepository {

    fun salvarVendas()

    fun novaVenda(): Venda



}