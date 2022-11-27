package com.innaval.vendasapp.domain.usecase

import com.innaval.vendasapp.data.repository.VendasRepository
import com.innaval.vendasapp.domain.Venda

class NovaVendaUseCase {

    lateinit var repository: VendasRepository

   suspend fun executar(): Venda {
        return repository.novaVenda()
    }
}