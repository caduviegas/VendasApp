package com.innaval.vendasapp.presentation.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.innaval.vendasapp.BaseFragment
import com.innaval.vendasapp.R
import com.innaval.vendasapp.di.VendasComponent
import com.innaval.vendasapp.domain.Produto
import com.innaval.vendasapp.domain.state.State
import com.innaval.vendasapp.presentation.adapter.ProdutoAdapter
import com.innaval.vendasapp.presentation.utils.formatCurrencyBR
import com.innaval.vendasapp.presentation.utils.popBackStack
import com.innaval.vendasapp.presentation.utils.safeNavigate
import com.innaval.vendasapp.presentation.viewmodel.ProdutoViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetalheVendaFragment:BaseFragment(R.layout.fragment_detalhe_venda), VendasComponent {

    private val viewModel: ProdutoViewModel by viewModel()
    private lateinit var botaoNovaVenda: ImageButton
    private lateinit var titulo:TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var somaProdutos: TextView
    private lateinit var quantidadeVendas: TextView
    private lateinit var adapter: ProdutoAdapter
    private val args:DetalheVendaFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews(view)
        observeViewModel()
        setupListener()
    }

    private fun setupViews(view: View) {
        botaoNovaVenda = view.findViewById(R.id.headerButton)
        recyclerView = view.findViewById(R.id.rvVendas)
        somaProdutos = view.findViewById(R.id.tvValorTotal)
        quantidadeVendas = view.findViewById(R.id.tvTotalVendas)
        titulo = view.findViewById(R.id.headerTitle)
    }

    private fun observeViewModel() {

        viewModel.produtos.observe(viewLifecycleOwner) {
            when (it) {
                is State.Carregando -> {}
                is State.Erro -> {}
                is State.Sucesso -> loadList(it.data)
            }
        }
        viewModel.carregarProdutos(args.venda.id)
    }

    private fun setupListener(){
        botaoNovaVenda.setOnClickListener {
            safeNavigate(DetalheVendaFragmentDirections.callNovoProduto(args.venda))
        }
    }

    private fun loadList(produto:List<Produto>){
        adapter = ProdutoAdapter(produto)
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
        val preco = produto.sumOf { it.preco * it.quantidade }
        somaProdutos.text = preco.formatCurrencyBR()
        quantidadeVendas.text = produto.size.toString()
        titulo.text = args.venda.descricao
    }

    override fun backPressed() {
        popBackStack(R.id.vendas)
    }


}