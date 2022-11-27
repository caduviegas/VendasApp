package com.innaval.vendasapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.innaval.vendasapp.domain.Venda
import com.innaval.vendasapp.domain.state.State
import com.innaval.vendasapp.domain.usecase.ListarVendasUseCase
import com.innaval.vendasapp.domain.usecase.SalvarVendaUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import java.util.*

class VendaViewModel(
    private val listarVendasUseCase: ListarVendasUseCase,
    private val salvarVendaUseCase: SalvarVendaUseCase,
    private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _vendas = MutableLiveData<State<List<Venda>>>()
    val vendas: LiveData<State<List<Venda>>> = _vendas

    private val _salvarVenda = MutableLiveData<State<Venda>>()
    val salvarVenda: LiveData<State<Venda>> = _salvarVenda


    fun carregarVendas() {
        _vendas.value = State.Carregando()

        viewModelScope.launch(dispatcher) {
            try {
                _vendas.postValue(State.Sucesso(listarVendasUseCase()))
            } catch (e: Exception) {
                _vendas.postValue(State.Erro())
            }
        }
    }

    fun salvarVenda(nomeCliente: String, descricao: String) {
        _salvarVenda.value = State.Carregando()

        viewModelScope.launch(dispatcher) {
            try {
                _salvarVenda.postValue(State.Sucesso(salvarVendaUseCase.invoke(
                    Venda(0, Date(), descricao, nomeCliente)
                )))

            } catch (e: Exception) {
                _salvarVenda.postValue(State.Erro())
            }
        }
    }
}