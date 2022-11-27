package com.innaval.vendasapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.innaval.vendasapp.R
import com.innaval.vendasapp.domain.Venda


class VendaAdapter(private val vendas: List<Venda>) :
    RecyclerView.Adapter<VendaAdapter.VendaViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VendaViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.row_venda,parent,false)
            return VendaViewHolder(view)
        }

    override fun onBindViewHolder(holder: VendaViewHolder, position: Int) {
        val venda = vendas[position]
        holder.bind(venda)
    }

    override fun getItemCount(): Int {
        return vendas.size
    }

    inner class VendaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(venda: Venda){
            val tvTitulo: TextView = itemView.findViewById(R.id.tvVendaName)
            tvTitulo.text = venda.descricao
        }
    }

}