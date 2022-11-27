package com.innaval.vendasapp.di

import android.content.Context
import com.innaval.vendasapp.di.modules.*

class VendasModuleProvider(private val context: Context) {

    fun provide() = listOf(
        DatabaseModule(context).provide(),
        DispatcherModule().provide(),
        RepositoryModule().provide(),
        UseCaseModule().provide(),
        ViewModelModule().provide()
    ).flatten()
}