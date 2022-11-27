package com.innaval.vendasapp.domain.usecase

import com.innaval.vendasapp.data.repository.VendasRepository
import com.innaval.vendasapp.domain.Produto
import com.innaval.vendasapp.domain.Venda

class SalvarProdutoUseCase(private val repository: VendasRepository ) {


    suspend operator fun invoke(produto: Produto): Long {
        return repository.salvarProduto(produto)
    }
}