package com.example.musicservice.presenter.client

import com.example.musicservice.firebase.auth.FirebaseAuthManager
import com.example.musicservice.firebase.dao.client.ClientDao
import com.example.musicservice.model.Client
import com.example.musicservice.mvpcontract.LoginContract
import com.example.musicservice.mvpcontract.client.ClientDetailsFormContract
import com.example.musicservice.presenter.BasePresenter
import javax.inject.Inject


class ClientDetailsFormPresenter @Inject constructor(private val auth : FirebaseAuthManager, private val clientDao : ClientDao) : BasePresenter<ClientDetailsFormContract.ClientDetailsFormView>, ClientDetailsFormContract.ClientDetailsFormPresenter {

    private lateinit var view : ClientDetailsFormContract.ClientDetailsFormView
    override fun setView(view: ClientDetailsFormContract.ClientDetailsFormView) {
        this.view = view
    }

    override fun handleForm(client: Client) {
        client.email = auth.getUserEmail()
        client.username = auth.getUserName()
        client.id = auth.getUserId()
        println(client)
        clientDao.save(client)
        view.startMainMenuActivity()
    }

    override fun returnUserName(): String {
        return auth.getUserName()
    }
}
