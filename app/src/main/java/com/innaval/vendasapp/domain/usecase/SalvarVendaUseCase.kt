package com.innaval.vendasapp.domain.usecase

import com.innaval.vendasapp.data.repository.VendasRepository
import com.innaval.vendasapp.domain.Venda

class SalvarVendaUseCase(private val repository: VendasRepository ) {

   suspend operator fun invoke(venda: Venda):Venda{
        return repository.salvarVenda(venda)
    }
}