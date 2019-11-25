package com.example.musicservice.di.modules

import com.example.musicservice.mvpcontract.LoginContract
import com.example.musicservice.mvpcontract.RegisterContract
import com.example.musicservice.presenter.LoginPresenter
import com.example.musicservice.presenter.RegisterPresenter
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Singleton
@Module(includes = [InteractionModule::class])
abstract class PresenterModule {

    @Binds
    abstract fun registrationPresenter(registerPresenter: RegisterPresenter) : RegisterContract.RegisterPresenter
    @Binds
    abstract fun loginPresenter(loginPresenter: LoginPresenter) : LoginContract.LoginPresenter
}