package com.innaval.vendasapp.di.modules

import com.innaval.vendasapp.presentation.viewmodel.ProdutoViewModel
import com.innaval.vendasapp.presentation.viewmodel.VendaViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class ViewModelModule {
    private val viewModelModule = module {
        viewModel {
            VendaViewModel(get(), get(), get())
        }

        viewModel{
            ProdutoViewModel(get(), get(), get())
        }
    }

    fun provide() = listOf(viewModelModule)
}