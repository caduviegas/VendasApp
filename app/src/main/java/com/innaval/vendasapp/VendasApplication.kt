package com.innaval.vendasapp

import android.app.Application
import com.innaval.vendasapp.di.VendasContext

class VendasApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        VendasContext.initialize(this)

    }
}