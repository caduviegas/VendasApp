package com.innaval.vendasapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.innaval.vendasapp.domain.Venda
import com.innaval.vendasapp.domain.state.State
import com.innaval.vendasapp.domain.usecase.ListarVendasUseCase
import com.innaval.vendasapp.domain.usecase.NovaVendaUseCase
import com.innaval.vendasapp.domain.usecase.SalvarVendaUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class VendaViewModel(
    private val listarVendasUseCase: ListarVendasUseCase,
    private val novaVendaUseCase: NovaVendaUseCase,
    private val salvarVendaUseCase: SalvarVendaUseCase,
    private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _vendas = MutableLiveData<State<List<Venda>>>()
    val vendas: LiveData<State<List<Venda>>> = _vendas

    fun carregarVendas() {
        _vendas.value = State.Carregando()

        viewModelScope.launch(dispatcher) {
            try {
                _vendas.postValue(State.Sucesso(listarVendasUseCase.executar()))
            } catch (e: Exception) {
                _vendas.postValue(State.Erro())
            }
        }
    }
}