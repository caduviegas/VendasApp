package com.innaval.vendasapp.presentation.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.navigation.fragment.navArgs
import com.google.android.material.textfield.TextInputEditText
import com.innaval.vendasapp.BaseFragment
import com.innaval.vendasapp.R
import com.innaval.vendasapp.di.VendasComponent
import com.innaval.vendasapp.domain.state.State
import com.innaval.vendasapp.presentation.utils.popBackStack
import com.innaval.vendasapp.presentation.viewmodel.ProdutoViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class NovoProdutoFragment : BaseFragment(R.layout.fragment_novo_produto), VendasComponent {
    private val viewModel: ProdutoViewModel by viewModel()
    private lateinit var backButton: ImageButton
    private lateinit var saveButton: ImageButton
    private lateinit var etNomeProduto: TextInputEditText
    private lateinit var etPrecoProduto: TextInputEditText
    private lateinit var etQuantidadeProduto: TextInputEditText
    private lateinit var etUnidadeMedida: TextInputEditText
    private val args: NovoProdutoFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews(view)
        observeViewModel()
        setupListener()
    }

    private fun setupViews(view: View) {
        backButton = view.findViewById(R.id.backButton)
        saveButton = view.findViewById(R.id.saveButton)
        etNomeProduto = view.findViewById(R.id.etNomeProduto)
        etPrecoProduto = view.findViewById(R.id.etPrecoProduto)
        etQuantidadeProduto = view.findViewById(R.id.etQuantidadeProduto)
        etUnidadeMedida = view.findViewById(R.id.etUnidadeMedida)
    }

    private fun observeViewModel() {
        viewModel.salvarProduto.observe(viewLifecycleOwner) {
            when (it) {
                is State.Carregando -> {}
                is State.Erro -> {}
                is State.Sucesso -> popBackStack()
            }
        }

    }

    private fun setupListener() {
        backButton.setOnClickListener {
            backPressed()
        }
        saveButton.setOnClickListener {
            viewModel.salvarProduto(
                vendaId = args.venda.id,
                nome = etNomeProduto.text.toString(),
                preco = etPrecoProduto.text.toString().toDouble(),
                quantidade = etQuantidadeProduto.text.toString().toDouble(),
                unidade = etUnidadeMedida.text.toString()
            )
        }
    }
}