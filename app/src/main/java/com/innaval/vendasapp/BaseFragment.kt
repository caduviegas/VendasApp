package com.innaval.vendasapp

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.innaval.vendasapp.presentation.utils.popBackStack

open class BaseFragment(private val layoutId: Int) : Fragment(layoutId) {

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            backPressed()
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            onBackPressedCallback
        )
    }

    protected open fun backPressed() {
        popBackStack()
    }

    override fun onResume() {
        super.onResume()
        onBackPressedCallback.isEnabled = true
    }

    override fun onStop() {
        super.onStop()
        onBackPressedCallback.isEnabled = false
    }
}