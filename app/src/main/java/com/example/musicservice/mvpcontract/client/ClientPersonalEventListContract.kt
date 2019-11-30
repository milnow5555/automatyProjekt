package com.example.musicservice.mvpcontract.client

import com.example.musicservice.model.Client
import com.example.musicservice.model.Event


interface ClientPersonalEventListContract {
    interface ClientPersonalEventListView {
        fun initializeRecyclerView(clietnsToEventsMap : MutableMap<String, MutableList<Event?>>)
        fun hideProgressBar()
        fun showProgressBar()
    }
    interface ClientPersonalEventListPresenter {
        fun getAllPersonalEvents()
        fun getUsername(): String
    }
}