package com.innaval.vendasapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.innaval.vendasapp.domain.Produto
import com.innaval.vendasapp.domain.state.State
import com.innaval.vendasapp.domain.usecase.ListarProdutosUseCase
import com.innaval.vendasapp.domain.usecase.SalvarProdutoUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class ProdutoViewModel(
    private val listarProdutosUseCase: ListarProdutosUseCase,
    private val salvarProdutoUseCase: SalvarProdutoUseCase,
    private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _produtos = MutableLiveData<State<List<Produto>>>()
    val produtos: LiveData<State<List<Produto>>> = _produtos

    private val _salvarProduto = MutableLiveData<State<Long>>()
    val salvarProduto: LiveData<State<Long>> = _salvarProduto

    fun carregarProdutos(vendaId: Long) {
        _produtos.value = State.Carregando()

        viewModelScope.launch(dispatcher) {
            try {
                _produtos.postValue(State.Sucesso(listarProdutosUseCase(vendaId)))
            } catch (e: Exception) {
                _produtos.postValue(State.Erro())
            }
        }
    }

    fun salvarProduto(nome: String, vendaId: Long, preco: Double, quantidade: Double, unidade: String) {
        _salvarProduto.value = State.Carregando()

        viewModelScope.launch(dispatcher) {
            try {
                _salvarProduto.postValue(
                    State.Sucesso(
                        salvarProdutoUseCase.invoke(
                            Produto(
                                id = 0,
                                vendaId = vendaId,
                                quantidade = quantidade,
                                preco = preco,
                                unidade = unidade,
                                nome = nome
                            )
                        )
                    )
                )
            } catch (e: Exception) {
                _salvarProduto.postValue(State.Erro())
            }
        }
    }

}