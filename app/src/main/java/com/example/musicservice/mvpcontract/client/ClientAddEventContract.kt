package com.example.musicservice.mvpcontract.client

import com.example.musicservice.model.Event

interface ClientAddEventContract {
    interface ClientAddEventView {
        fun onAddEventSuccess()
        fun showProgressBar()
        fun hideProgressBar()
    }
    interface ClientAddEventPresenter {
        fun getUsername(): String
        fun getUserId(): String
        fun handleEventForm(event : Event)
    }
}