package com.innaval.vendasapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.innaval.vendasapp.domain.Venda

@Dao
interface VendaDao {

    @Query("SELECT * FROM Venda")
    fun findAll():List<Venda>

    @Insert
    fun insert(venda: Venda)
}