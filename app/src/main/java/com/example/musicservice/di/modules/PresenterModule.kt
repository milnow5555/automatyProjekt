package com.example.musicservice.di.modules

import com.example.musicservice.mvpcontract.RegisterContract
import com.example.musicservice.presenter.LoginPresenter
import com.example.musicservice.presenter.RegisterPresenter
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Singleton
@Module
abstract class PresenterModule {

    @Binds
    abstract fun registrationPresenter(registerPresenter: RegisterPresenter) : RegisterContract
    @Binds
    abstract fun loginPresenter(loginPresenter: LoginPresenter) : LoginPresenter
}