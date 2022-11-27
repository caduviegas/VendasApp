package com.innaval.vendasapp.data.repository

import com.innaval.vendasapp.domain.Produto
import com.innaval.vendasapp.domain.Venda

interface VendasRepository {

    suspend fun salvarVenda(venda: Venda): Long

    suspend fun listarVendas(): List<Venda>

    suspend fun salvarProduto(produto: Produto): Long

    suspend fun listarProdutos(vendaId: Long): List<Produto>

}