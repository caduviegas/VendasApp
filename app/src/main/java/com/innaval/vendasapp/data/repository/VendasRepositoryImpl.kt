package com.innaval.vendasapp.data.repository

import com.innaval.vendasapp.domain.Produto
import com.innaval.vendasapp.domain.Venda

class VendasRepositoryImpl: VendasRepository {
    override suspend fun salvarVenda(venda: Venda): Venda {
        TODO("Not yet implemented")
    }

    override suspend fun listarVendas(): List<Venda> {
        TODO("Not yet implemented")
    }

    override suspend fun salvarProduto(produto: Produto): Produto {
        TODO("Not yet implemented")
    }

    override suspend fun listarProdutos(vendaId: Int): List<Produto> {
        TODO("Not yet implemented")
    }
}