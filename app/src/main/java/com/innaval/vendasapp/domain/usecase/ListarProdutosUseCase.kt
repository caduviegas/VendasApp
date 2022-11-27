package com.innaval.vendasapp.domain.usecase

import com.innaval.vendasapp.data.repository.VendasRepository
import com.innaval.vendasapp.domain.Produto
import com.innaval.vendasapp.domain.Venda

class ListarProdutosUseCase(private val repository: VendasRepository ) {


    suspend operator fun invoke(vendasId: Long): List<Produto> {
        return repository.listarProdutos(vendasId)
    }
}