package com.acmelabs.rickandmortydex

import android.app.Application
import com.acmelabs.rickandmortydex.injections.rickAndMortyModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RickAndMortyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@RickAndMortyApp)
            modules(rickAndMortyModule)
        }
    }

}