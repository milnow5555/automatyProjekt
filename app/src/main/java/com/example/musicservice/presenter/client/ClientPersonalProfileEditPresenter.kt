package com.example.musicservice.presenter.client

import com.example.musicservice.firebase.auth.FirebaseAuthManager
import com.example.musicservice.firebase.dao.client.ClientDao
import com.example.musicservice.model.Client
import com.example.musicservice.mvpcontract.client.ClientPersonalProfileEditContract
import com.example.musicservice.presenter.BasePresenter
import javax.inject.Inject

class ClientPersonalProfileEditPresenter @Inject constructor(private val auth : FirebaseAuthManager, private val clientDao: ClientDao)
    : BasePresenter<ClientPersonalProfileEditContract.ClientPersonalProfileEditView>
    , ClientPersonalProfileEditContract.ClientPersonalProfileEditPresenter {
    override fun getUsername(): String = auth.getUserName()

    private lateinit var view : ClientPersonalProfileEditContract.ClientPersonalProfileEditView
    override fun setView(view: ClientPersonalProfileEditContract.ClientPersonalProfileEditView) {
        this.view = view
    }

    override fun updateProfile(client : Client) {
        clientDao.updateClient(client)
    }
}