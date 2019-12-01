package com.example.musicservice.presenter.client

import com.example.musicservice.firebase.auth.FirebaseAuthManager
import com.example.musicservice.firebase.dao.client.ClientDao
import com.example.musicservice.firebase.dao.event.EventDao
import com.example.musicservice.model.Client
import com.example.musicservice.model.Event
import com.example.musicservice.mvpcontract.client.ClientPersonalEventDetailsContract
import com.example.musicservice.presenter.BasePresenter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import java.util.concurrent.CompletableFuture
import javax.inject.Inject

class ClientPersonalEventDetailsPresenter @Inject constructor(private val auth : FirebaseAuthManager, private val clientDao: ClientDao, private val eventDao : EventDao) : BasePresenter<ClientPersonalEventDetailsContract.CLientPersonalEventDetailsView>,
    ClientPersonalEventDetailsContract.ClientPersonalEventDetailsPresenter {
    override fun getUsername() : String {
        return auth.getUserName()
    }


    private lateinit var view : ClientPersonalEventDetailsContract.CLientPersonalEventDetailsView
    override fun setView(view: ClientPersonalEventDetailsContract.CLientPersonalEventDetailsView) {
        this.view = view
    }
    override fun loadEventData(eventId : String) {
        val eventReference = eventDao.getById(eventId)
        var event : Event?
        view.showProgressBar()
        eventReference.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if(dataSnapshot.exists()) {
                    event = dataSnapshot.getValue(Event::class.java)
                    view.hideProgressBar()
                    view.setEventData(event)
                }
            }
        })
    }

    override fun loadClientData() {
        val concreteUser = clientDao.getByCurrentUserId()
        var client : Client?
        view.showProgressBar()

        concreteUser.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if(dataSnapshot.exists()) {
                    client = dataSnapshot.getValue(Client::class.java)
                    view.hideProgressBar()
                    view.setClientData(client)
                }
            }
        })
    }


}