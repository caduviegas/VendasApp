package com.innaval.vendasapp.di.modules

import com.innaval.vendasapp.data.repository.VendasRepositoryImpl
import com.innaval.vendasapp.domain.usecase.ListarProdutosUseCase
import com.innaval.vendasapp.domain.usecase.ListarVendasUseCase
import com.innaval.vendasapp.domain.usecase.SalvarProdutoUseCase
import com.innaval.vendasapp.domain.usecase.SalvarVendaUseCase
import org.koin.dsl.module

class UseCaseModule {
    private val useCaseModule = module {
        single {
            ListarProdutosUseCase(get())
        }

        single {
            ListarVendasUseCase(get())
        }

        single {
            SalvarProdutoUseCase(get())
        }

        single {
            SalvarVendaUseCase(get())
        }
    }

    fun provide() = listOf(useCaseModule)
}