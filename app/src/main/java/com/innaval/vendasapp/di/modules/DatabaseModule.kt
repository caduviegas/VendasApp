package com.innaval.vendasapp.di.modules

import android.content.Context
import androidx.room.Room
import com.innaval.vendasapp.data.local.VendasDatabase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

class DatabaseModule(private val context: Context) {

    fun provide(): List<Module> {
        return listOf(databaseModule,daoModule)
    }

    private val databaseModule = module {
        single {
            Room.databaseBuilder(context, VendasDatabase::class.java, "vendas").build()
        }
    }

    private val daoModule = module {
        single {
            val database = get<VendasDatabase>()
            database.vendaDao()
        }
        single {
            val database = get<VendasDatabase>()
            database.produtoDao()
        }
    }

}