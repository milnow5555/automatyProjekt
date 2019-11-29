package com.example.musicservice.mvpcontract.client

import com.example.musicservice.model.Client
import com.google.firebase.database.ValueEventListener

interface ClientPersonalProfileContract {
    interface ClientPersonalProfileView {
        fun setClientPersonalProfileData(client : Client?)
        fun showProgressBar()
        fun hideProgressBar()

    }
    interface ClientPersonalProfilePresenter {
        fun myEvents()
        fun editProfile()
    }
}