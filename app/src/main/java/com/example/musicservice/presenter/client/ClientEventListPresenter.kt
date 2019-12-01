package com.example.musicservice.presenter.client

import com.example.musicservice.firebase.auth.FirebaseAuthManager
import com.example.musicservice.firebase.dao.event.EventDao
import com.example.musicservice.model.Client
import com.example.musicservice.model.Event
import com.example.musicservice.mvpcontract.client.ClientEventListContract
import com.example.musicservice.presenter.BasePresenter
import java.util.LinkedHashMap
import javax.inject.Inject

class ClientEventListPresenter @Inject constructor(private val auth : FirebaseAuthManager, private val eventDao : EventDao)
    : BasePresenter<ClientEventListContract.ClientEventListView>, ClientEventListContract.ClientEventListPresenter {

    private lateinit var view : ClientEventListContract.ClientEventListView

    override fun setView(view: ClientEventListContract.ClientEventListView) {
        this.view = view
    }

    override fun obtainAllEvents() {
        var viewInvoker : (mapOfEvents: LinkedHashMap<Client?, MutableList<Event?>>) -> Unit = {
            view.initializeRecyclerView(it)
        }
        var progressBarInvoker : () -> Unit = {
            view.progressBarReaction()
        }
        eventDao.getAll(viewInvoker,progressBarInvoker)
    }

    override fun getUsername(): String = auth.getUserName()
}