package com.example.musicservice.mvpcontract.client

import com.example.musicservice.model.Client
import com.example.musicservice.model.Event
import java.util.LinkedHashMap

interface ClientEventListContract {
    interface ClientEventListView {
        fun initializeRecyclerView(clientsEventList : MutableMap<Client?, MutableList<Event?>>)
        fun onClickedItemView(eventId : String?)
        fun progressBarReaction()
    }
    interface ClientEventListPresenter {
        fun obtainAllEvents()
        fun getUsername(): String
    }
}