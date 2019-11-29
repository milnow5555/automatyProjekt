package com.example.musicservice.firebase.dao.event

import com.example.musicservice.firebase.dao.FirebaseDao
import com.example.musicservice.model.Event
import com.example.musicservice.mvpcontract.client.ClientPersonalEventListContract
import com.google.firebase.database.DatabaseReference

interface EventDao : FirebaseDao<Event>{
    fun getAllEventsByClientId(clientId : String,clientPersonalEventListView: ClientPersonalEventListContract.ClientPersonalEventListView)

}