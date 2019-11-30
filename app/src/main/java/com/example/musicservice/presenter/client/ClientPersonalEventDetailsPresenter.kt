package com.example.musicservice.presenter.client

import com.example.musicservice.firebase.auth.FirebaseAuthManager
import com.example.musicservice.firebase.dao.client.ClientDao
import com.example.musicservice.mvpcontract.client.ClientPersonalEventDetailsContract
import com.example.musicservice.presenter.BasePresenter
import javax.inject.Inject

class ClientPersonalEventDetailsPresenter @Inject constructor(private val auth : FirebaseAuthManager, private val clientDao: ClientDao) : BasePresenter<ClientPersonalEventDetailsContract.CLientPersonalEventDetailsView>,
    ClientPersonalEventDetailsContract.ClientPersonalEventDetailsPresenter {

    private lateinit var view : ClientPersonalEventDetailsContract.CLientPersonalEventDetailsView
    override fun setView(view: ClientPersonalEventDetailsContract.CLientPersonalEventDetailsView) {
        this.view = view
    }


}