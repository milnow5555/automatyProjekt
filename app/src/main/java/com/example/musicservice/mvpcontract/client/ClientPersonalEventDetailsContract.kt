package com.example.musicservice.mvpcontract.client

import com.example.musicservice.model.Client
import com.example.musicservice.model.Event

interface ClientPersonalEventDetailsContract {
    interface CLientPersonalEventDetailsView{
        fun setEventData(client : Client?)
        fun setClientData(client : Client?)
    }
    interface ClientPersonalEventDetailsPresenter {
        fun loadEventData()
        fun loadClientData()
    }
}