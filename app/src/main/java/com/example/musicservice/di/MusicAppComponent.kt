package com.example.musicservice.di

import com.example.musicservice.di.modules.AppModule
import com.example.musicservice.di.modules.FirebaseModule
import com.example.musicservice.di.modules.PresenterModule
import com.example.musicservice.presenter.LoginPresenter
import com.example.musicservice.presenter.RegisterPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, PresenterModule::class])
interface MusicAppComponent {
    fun registerPresenter(): RegisterPresenter
    fun loginPresenter(): LoginPresenter
}