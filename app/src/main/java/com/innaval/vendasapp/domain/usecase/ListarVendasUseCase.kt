package com.innaval.vendasapp.domain.usecase

import com.innaval.vendasapp.data.repository.VendasRepository
import com.innaval.vendasapp.domain.Venda

class ListarVendasUseCase {
    lateinit var repository: VendasRepository

    suspend fun executar():List<Venda>{
        return repository.listarVendas()
    }
}