package com.innaval.vendasapp.di.modules

import com.innaval.vendasapp.data.repository.VendasRepository
import com.innaval.vendasapp.data.repository.VendasRepositoryImpl
import org.koin.dsl.module

class RepositoryModule {
    private val repositoryModule = module {
        single<VendasRepository> {
            VendasRepositoryImpl(get(),get())
        }
    }

    fun provide() = listOf(repositoryModule)
}