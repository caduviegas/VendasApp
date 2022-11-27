package com.innaval.vendasapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.innaval.vendasapp.domain.Produto


@Dao
interface ProdutoDao {

    @Query("SELECT * FROM Produto WHERE vendaId = :vendaId")
    fun findAll(vendaId: Long): List<Produto>

    @Insert
    fun insert(produto: Produto)
}