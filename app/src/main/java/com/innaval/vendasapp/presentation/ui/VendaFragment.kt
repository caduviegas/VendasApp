package com.innaval.vendasapp.presentation.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.innaval.vendasapp.R
import com.innaval.vendasapp.presentation.viewmodel.VendaViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class VendaFragment : Fragment(R.layout.fragment_venda) {
    private val viewModel: VendaViewModel by viewModel()
    private lateinit var botaoNovaVenda: ImageButton


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        botaoNovaVenda = view.findViewById(R.id.headerButton)
        botaoNovaVenda.setOnClickListener {
            findNavController().navigate(R.id.callNovaVenda)
            //findNavController().popBackStack()
        }

    }
}