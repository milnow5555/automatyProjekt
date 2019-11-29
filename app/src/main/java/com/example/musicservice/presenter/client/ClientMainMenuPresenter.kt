package com.example.musicservice.presenter.client

import com.example.musicservice.firebase.auth.FirebaseAuthManager
import com.example.musicservice.mvpcontract.client.ClientMainMenuContract
import com.example.musicservice.presenter.BasePresenter
import javax.inject.Inject

class ClientMainMenuPresenter @Inject constructor(private val auth : FirebaseAuthManager) : BasePresenter<ClientMainMenuContract.ClientMainMenuView>, ClientMainMenuContract.ClientMainMenuPresenter {

    private lateinit var mainmenuView : ClientMainMenuContract.ClientMainMenuView
    override fun setView(view: ClientMainMenuContract.ClientMainMenuView) {
        this.mainmenuView = view
    }
    override fun exampleMethod() {
        println("CLIENT ${auth.getUserName()}")
    }

    override fun returnUserName(): String {
        return auth.getUserName()
    }
    override fun logOut() {
        auth.logOut()
        mainmenuView.goBackToLogin()
    }


}