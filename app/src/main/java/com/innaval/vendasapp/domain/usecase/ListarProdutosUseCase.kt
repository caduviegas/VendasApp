package com.innaval.vendasapp.domain.usecase

import com.innaval.vendasapp.data.repository.VendasRepository
import com.innaval.vendasapp.domain.Produto
import com.innaval.vendasapp.domain.Venda

class ListarProdutosUseCase {
    lateinit var repository: VendasRepository

    suspend operator fun invoke(vendasId: Int): List<Produto> {
        return repository.listarProdutos(vendasId)
    }
}