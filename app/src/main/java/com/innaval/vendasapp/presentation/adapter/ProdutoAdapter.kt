package com.innaval.vendasapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.innaval.vendasapp.R
import com.innaval.vendasapp.domain.Produto
import com.innaval.vendasapp.presentation.utils.formatCurrencyBR

class ProdutoAdapter(private val detalheVendas: List<Produto>) :
    RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_produto, parent, false)
        return ProdutoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        val produto = detalheVendas[position]
        holder.bind(produto)
    }

    override fun getItemCount(): Int {
        return detalheVendas.size
    }

    inner class ProdutoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(detalheVenda: Produto){

            val tvProductName: TextView = itemView.findViewById(R.id.tvProductName)
            tvProductName.text =detalheVenda.nome

            val tvProductValue: TextView = itemView.findViewById(R.id.tvProductValue)
            tvProductValue.text = detalheVenda.preco.formatCurrencyBR()

            val tvProductQuantity: TextView = itemView.findViewById(R.id.tvProductQuantity)
            tvProductQuantity.text = "${detalheVenda.quantidade} ${detalheVenda.unidade}"
        }
    }

}