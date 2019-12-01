package com.example.musicservice.mvpcontract.client

import com.example.musicservice.model.Client

interface ClientPersonalProfileEditContract {
    interface ClientPersonalProfileEditView {

    }
    interface ClientPersonalProfileEditPresenter{
        fun getUsername(): String
        fun updateProfile(client : Client)
    }
}