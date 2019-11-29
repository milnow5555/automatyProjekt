package com.example.musicservice.presenter.client

import com.example.musicservice.firebase.auth.FirebaseAuthManager
import com.example.musicservice.firebase.dao.client.ClientDao
import com.example.musicservice.firebase.dao.event.EventDao
import com.example.musicservice.model.Event
import com.example.musicservice.mvpcontract.client.ClientAddEventContract
import com.example.musicservice.presenter.BasePresenter
import javax.inject.Inject

class ClientAddEventPresenter @Inject constructor(private val auth : FirebaseAuthManager, private val eventDao : EventDao): BasePresenter<ClientAddEventContract.ClientAddEventView>, ClientAddEventContract.ClientAddEventPresenter {

    private lateinit var view : ClientAddEventContract.ClientAddEventView
    override fun setView(view: ClientAddEventContract.ClientAddEventView) {
        this.view = view
    }

    override fun getUsername(): String = auth.getUserName()

    override fun getUserId(): String = auth.getUserId()

    override fun handleEventForm(event: Event) = eventDao.save(event)

}