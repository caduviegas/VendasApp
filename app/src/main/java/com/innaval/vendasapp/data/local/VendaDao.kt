package com.innaval.vendasapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.innaval.vendasapp.domain.Venda

@Dao
interface VendaDao {

    @Query("SELECT * FROM Venda")
    fun findAll():List<Venda>

    @Insert
    fun insert(venda: Venda):Long

    @Query("SELECT sum(preco) as 'preco' FROM Produto WHERE vendaId = :vendaId")
    fun somaprecoProdutos(vendaId:Long):Double

    @Update
    fun update(venda: Venda)

    @Query("SELECT * FROM venda WHERE id = :vendaId")
    fun findById(vendaId: Long):Venda
}