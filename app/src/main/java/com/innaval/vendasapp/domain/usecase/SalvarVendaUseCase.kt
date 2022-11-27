package com.innaval.vendasapp.domain.usecase

import com.innaval.vendasapp.data.repository.VendasRepository
import com.innaval.vendasapp.domain.Venda

class SalvarVendaUseCase {

    lateinit var repository: VendasRepository

   suspend fun executar(venda: Venda){
        return repository.salvarVendas()
    }
}