package com.innaval.vendasapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import com.innaval.vendasapp.databinding.ActivityVendasBinding

class VendasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVendasBinding
    private val host: NavHostFragment by lazy { supportFragmentManager.findFragmentById(R.id.fragmentNavigation) as NavHostFragment }
    private val graph: NavGraph by lazy { host.navController.navInflater.inflate(R.navigation.navi_vendas) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVendasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        graph.setStartDestination(R.id.vendas)
        host.navController.graph = graph
    }

    override fun onBackPressed() {

    }
}