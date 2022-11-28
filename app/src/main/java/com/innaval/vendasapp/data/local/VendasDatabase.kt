package com.innaval.vendasapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.innaval.vendasapp.domain.Produto
import com.innaval.vendasapp.domain.Venda

@Database(entities = [Produto::class, Venda::class], version = 1)
@TypeConverters(value = [DateConverter::class])
abstract class VendasDatabase:RoomDatabase() {


    abstract fun vendaDao(): VendaDao

    abstract fun produtoDao(): ProdutoDao
}