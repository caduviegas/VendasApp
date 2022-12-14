package com.innaval.vendasapp.presentation.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.innaval.vendasapp.BaseFragment
import com.innaval.vendasapp.R
import com.innaval.vendasapp.di.VendasComponent
import com.innaval.vendasapp.domain.Venda
import com.innaval.vendasapp.domain.state.State
import com.innaval.vendasapp.presentation.adapter.VendaAdapter
import com.innaval.vendasapp.presentation.utils.formatCurrencyBR
import com.innaval.vendasapp.presentation.utils.safeNavigate
import com.innaval.vendasapp.presentation.viewmodel.VendaViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class VendaFragment : BaseFragment(R.layout.fragment_venda), VendasComponent {
    private val viewModel: VendaViewModel by viewModel()
    private lateinit var botaoNovaVenda: ImageButton
    private lateinit var recyclerView: RecyclerView
    private lateinit var somaVendas: TextView
    private lateinit var quantidadeVendas: TextView
    private lateinit var adapter: VendaAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews(view)
        observeViewModel()
        setupListener()
    }

    private fun setupViews(view: View) {
        botaoNovaVenda = view.findViewById(R.id.headerButton)
        recyclerView = view.findViewById(R.id.rvVendas)
        somaVendas = view.findViewById(R.id.tvValorTotal)
        quantidadeVendas = view.findViewById(R.id.tvTotalVendas)
    }

    private fun observeViewModel() {
        viewModel.vendas.observe(viewLifecycleOwner) {
            when (it) {
                is State.Carregando -> {}
                is State.Erro -> {}
                is State.Sucesso -> loadList(it.data)
            }
        }
        viewModel.carregarVendas()
    }

    private fun setupListener() {
        botaoNovaVenda.setOnClickListener {
            safeNavigate(VendaFragmentDirections.callNovaVenda())
        }
    }

    private fun loadList(vendas: List<Venda>) {
        adapter = VendaAdapter(vendas) {
            safeNavigate(VendaFragmentDirections.callDetalhesVenda(it))
        }
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
        val preco = vendas.sumOf { it.preco }
        somaVendas.text = preco.formatCurrencyBR()
        quantidadeVendas.text = vendas.size.toString()
    }
}