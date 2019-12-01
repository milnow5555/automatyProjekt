package com.example.musicservice.presenter.client

import com.example.musicservice.firebase.auth.FirebaseAuthManager
import com.example.musicservice.firebase.dao.client.ClientDao
import com.example.musicservice.firebase.dao.event.EventDao
import com.example.musicservice.model.Event
import com.example.musicservice.mvpcontract.client.ClientPersonalEventListContract
import com.example.musicservice.presenter.BasePresenter
import javax.inject.Inject

class ClientPersonalEventListPresenter @Inject constructor(private val auth : FirebaseAuthManager, private val clientDao: ClientDao, private val eventDao : EventDao)
    : BasePresenter<ClientPersonalEventListContract.ClientPersonalEventListView>, ClientPersonalEventListContract.ClientPersonalEventListPresenter {
    override fun getUsername(): String = auth.getUserName()

    private lateinit var personalEventListView : ClientPersonalEventListContract.ClientPersonalEventListView

    override fun setView(view: ClientPersonalEventListContract.ClientPersonalEventListView) {
        personalEventListView = view
    }

    override fun getAllPersonalEvents() {
         eventDao.getAllEventsByClientId(auth.getUserId(), personalEventListView)
    }




}