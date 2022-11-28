package com.innaval.vendasapp.presentation.utils

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

fun Fragment.safeNavigate(directions: NavDirections) {
    findNavController().currentDestination?.getAction(directions.actionId)?.let {
        findNavController().navigate(directions)
    }
}

fun Fragment.popBackStack(@IdRes destinationId: Int) {
    var isPopped = findNavController().popBackStack(destinationId, false)
    if (!isPopped) {
        isPopped = findNavController().popBackStack(destinationId, true)
        if (!isPopped) {
            findNavController().popBackStack()
        }
    }
}

fun Fragment.popBackStack() {
    findNavController().popBackStack()
}