package com.innaval.vendasapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.innaval.vendasapp.R
import com.innaval.vendasapp.domain.Venda
import com.innaval.vendasapp.presentation.utils.formatCurrencyBR
import com.innaval.vendasapp.presentation.utils.formatDateBR
import org.w3c.dom.Text


class VendaAdapter(private val vendas: List<Venda>, private val vendaClick: (Venda) -> Unit) :
    RecyclerView.Adapter<VendaAdapter.VendaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VendaViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_venda, parent, false)
        return VendaViewHolder(view)
    }

    override fun onBindViewHolder(holder: VendaViewHolder, position: Int) {
        val venda = vendas[position]
        holder.bind(venda, vendaClick)
    }

    override fun getItemCount(): Int {
        return vendas.size
    }

    inner class VendaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(venda: Venda, vendaClick: (Venda) -> Unit) {
            itemView.setOnClickListener {
                vendaClick(venda)
            }
            val tvTitulo: TextView = itemView.findViewById(R.id.tvVendaName)
            tvTitulo.text = venda.descricao

            val tvVendaValue: TextView = itemView.findViewById(R.id.tvProductValue)
            tvVendaValue.text = venda.preco.formatCurrencyBR()

            val tvVendaDate: TextView = itemView.findViewById(R.id.tvVendaDate)
            tvVendaDate.text = venda.dataCriacao.formatDateBR()

            val tvProductQuantity: TextView = itemView.findViewById(R.id.tvProductQuantity)
            val produtoPlurals = itemView.resources.getQuantityText(
                R.plurals.plurals_produtos,
                venda.quantidadeProdutosVenda.toInt()
            )
            tvProductQuantity.text = "${venda.quantidadeProdutosVenda} $produtoPlurals"

            val tvNomeCliente: TextView = itemView.findViewById(R.id.tvNomeCliente)
            tvNomeCliente.text = venda.nomeCliente
        }
    }

}