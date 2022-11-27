package com.innaval.vendasapp.di

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.core.KoinApplication
import org.koin.dsl.koinApplication

object VendasContext {
    lateinit var koinApp:KoinApplication

    fun initialize(context:Context){
        val modules = VendasModuleProvider(context).provide()
        koinApp = koinApplication{
            androidContext(context)
            modules(modules)
        }
    }
}