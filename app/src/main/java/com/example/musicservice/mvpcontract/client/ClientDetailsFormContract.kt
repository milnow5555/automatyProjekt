package com.example.musicservice.mvpcontract.client

import com.example.musicservice.model.Client

interface ClientDetailsFormContract {
    interface ClientDetailsFormView{
        fun startMainMenuActivity()
    }
    interface ClientDetailsFormPresenter {
        fun handleForm(client : Client)
        fun returnUserName(): String
    }
}