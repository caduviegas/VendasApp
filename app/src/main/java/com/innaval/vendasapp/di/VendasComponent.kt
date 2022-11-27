package com.innaval.vendasapp.di

import org.koin.core.Koin
import org.koin.core.component.KoinComponent

interface VendasComponent : KoinComponent {
    override fun getKoin(): Koin {
        return VendasContext.koinApp.koin
    }
}