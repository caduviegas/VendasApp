package com.innaval.vendasapp.domain

import com.innaval.vendasapp.data.repository.VendasRepository

class SalvarVendaUseCase {

    lateinit var repository: VendasRepository

    fun executar(venda: Venda){
        return repository.salvarVendas()
    }
}