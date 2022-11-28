package com.innaval.vendasapp.presentation.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.google.android.material.textfield.TextInputEditText
import com.innaval.vendasapp.BaseFragment
import com.innaval.vendasapp.R
import com.innaval.vendasapp.di.VendasComponent
import com.innaval.vendasapp.domain.Venda
import com.innaval.vendasapp.domain.state.State
import com.innaval.vendasapp.presentation.utils.safeNavigate
import com.innaval.vendasapp.presentation.viewmodel.VendaViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class NovaVendaFragment : BaseFragment(R.layout.fragment_nova_venda), VendasComponent {
    private val viewModel: VendaViewModel by viewModel()
    private lateinit var backButton: ImageButton
    private lateinit var saveButton: ImageButton
    private lateinit var etDescricaoCliente: TextInputEditText
    private lateinit var etDescricaoVenda: TextInputEditText


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews(view)
        observeViewModel()
        setupListener()
    }

    private fun setupViews(view: View) {
        backButton = view.findViewById(R.id.backButton)
        saveButton = view.findViewById(R.id.saveButton)
        etDescricaoCliente = view.findViewById(R.id.etDescricaoCliente)
        etDescricaoVenda = view.findViewById(R.id.etDescricaoVenda)
    }

    private fun observeViewModel() {
        viewModel.salvarVenda.observe(viewLifecycleOwner) {
            when (it) {
                is State.Carregando -> {}
                is State.Erro -> {}
                is State.Sucesso -> callFragment(it.data)
            }
        }

    }

    private fun callFragment(venda: Venda){
        safeNavigate(NovaVendaFragmentDirections.callNovoDetalhesVenda(venda))
    }

    private fun setupListener() {
        backButton.setOnClickListener {
            backPressed()
        }

        saveButton.setOnClickListener {
            viewModel.salvarVenda(
                nomeCliente = etDescricaoCliente.text.toString(),
                descricao = etDescricaoVenda.text.toString()

            )
        }
    }
}