package com.example.musicservice.mvpcontract.client

import com.example.musicservice.model.Client
import com.example.musicservice.model.Event

interface ClientPersonalEventDetailsContract {
    interface CLientPersonalEventDetailsView{
        fun setEventData(client : Event?)
        fun setClientData(client : Client?)
        fun showProgressBar()
        fun hideProgressBar()
    }
    interface ClientPersonalEventDetailsPresenter {
        fun loadEventData(eventId : String)
        fun getUsername() : String
    }
}