package com.innaval.vendasapp.data.repository

import com.innaval.vendasapp.data.local.ProdutoDao
import com.innaval.vendasapp.data.local.VendaDao
import com.innaval.vendasapp.domain.Produto
import com.innaval.vendasapp.domain.Venda

class VendasRepositoryImpl(private val vendaDao: VendaDao, private val produtoDao: ProdutoDao) :
    VendasRepository {
    override suspend fun salvarVenda(venda: Venda): Venda {
        val vendaId = vendaDao.insert(venda)
        return vendaDao.findById(vendaId)
    }

    override suspend fun listarVendas(): List<Venda> {
        return vendaDao.findAll()
    }

    override suspend fun salvarProduto(detalheVenda: Produto): Long {
        val venda = vendaDao.findById(detalheVenda.vendaId)
        val vendaAtualizada = Venda(
            venda.id,
            venda.preco + (detalheVenda.preco * detalheVenda.quantidade),
            venda.quantidadeProdutosVenda + 1,
            venda.dataCriacao,
            venda.descricao,
            venda.nomeCliente
        )
        vendaDao.update(vendaAtualizada)
        return produtoDao.insert(detalheVenda)
    }

    override suspend fun listarProdutos(vendaId: Long): List<Produto> {
        return produtoDao.findAll(vendaId)
    }
}