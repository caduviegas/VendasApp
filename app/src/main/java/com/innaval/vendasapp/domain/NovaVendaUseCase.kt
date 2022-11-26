package com.innaval.vendasapp.domain

import com.innaval.vendasapp.data.repository.VendasRepository

class NovaVendaUseCase {

    lateinit var repository: VendasRepository

    fun executar():Venda {
        return repository.novaVenda()
    }
}