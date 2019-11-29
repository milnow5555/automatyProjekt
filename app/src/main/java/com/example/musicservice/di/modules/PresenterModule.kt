package com.example.musicservice.di.modules

import com.example.musicservice.mvpcontract.LoginContract
import com.example.musicservice.mvpcontract.RegisterContract
import com.example.musicservice.mvpcontract.client.ClientDetailsFormContract
import com.example.musicservice.mvpcontract.client.ClientMainMenuContract
import com.example.musicservice.mvpcontract.client.ClientPersonalProfileContract
import com.example.musicservice.presenter.LoginPresenter
import com.example.musicservice.presenter.RegisterPresenter
import com.example.musicservice.presenter.client.ClientDetailsFormPresenter
import com.example.musicservice.presenter.client.ClientMainMenuPresenter
import com.example.musicservice.presenter.client.ClientPersonalProfilePresenter
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
    @Binds
    abstract fun clienDetailsFormPresenter(clientDetailsFormPresenter: ClientDetailsFormPresenter) : ClientDetailsFormContract.ClientDetailsFormPresenter
    @Binds
    abstract fun clientMainMenuPresenter(clientMainMenuPresenter: ClientMainMenuPresenter) : ClientMainMenuContract.ClientMainMenuPresenter
    @Binds
    abstract fun clientPersonalProfilePresenter(clientPersonalProfilePresenter : ClientPersonalProfilePresenter) : ClientPersonalProfileContract.ClientPersonalProfilePresenter



}