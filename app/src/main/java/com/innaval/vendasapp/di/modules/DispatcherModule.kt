package com.innaval.vendasapp.di.modules

import com.innaval.vendasapp.data.repository.VendasRepositoryImpl
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

class DispatcherModule {
    private val dispatcherModule = module {
        single {
            Dispatchers.IO
        }
    }

    fun provide() = listOf(dispatcherModule)
}