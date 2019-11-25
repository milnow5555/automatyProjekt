package com.example.musicservice

import android.app.Application
import com.example.musicservice.di.MusicAppComponent
import com.google.firebase.FirebaseApp

class MusicApp : Application() {

    companion object {
        lateinit var instance: MusicApp
            private set

        val component: MusicAppComponent by lazy { DaggerMusicAppComponent.builder().build() }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        FirebaseApp.initializeApp(this)
    }
}