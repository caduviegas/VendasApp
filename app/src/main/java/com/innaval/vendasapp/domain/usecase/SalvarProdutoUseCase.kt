package com.innaval.vendasapp.domain.usecase

import com.innaval.vendasapp.data.repository.VendasRepository
import com.innaval.vendasapp.domain.Produto

class SalvarProdutoUseCase(private val repository: VendasRepository ) {


    suspend operator fun invoke(detalheVenda: Produto): Long {
        return repository.salvarProduto(detalheVenda)
    }
}