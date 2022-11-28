package com.innaval.vendasapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.innaval.vendasapp.R
import com.innaval.vendasapp.domain.Produto
import com.innaval.vendasapp.domain.Venda
import com.innaval.vendasapp.presentation.utils.formatCurrencyBR

class ProdutoAdapter(private val produtos: List<Produto>) :
    RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_produto, parent, false)
        return ProdutoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        val produto = produtos[position]
        holder.bind(produto)
    }

    override fun getItemCount(): Int {
        return produtos.size
    }

    inner class ProdutoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(produto: Produto){

            val tvProductName: TextView = itemView.findViewById(R.id.tvProductName)
            tvProductName.text =produto.nome

            val tvProductValue: TextView = itemView.findViewById(R.id.tvProductValue)
            tvProductValue.text = produto.preco.formatCurrencyBR()

            val tvProductQuantity: TextView = itemView.findViewById(R.id.tvProductQuantity)
            tvProductQuantity.text = "${produto.quantidade} ${produto.unidade}"
        }
    }

}