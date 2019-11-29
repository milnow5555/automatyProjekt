package com.example.musicservice.mvpcontract.client

interface ClientMainMenuContract  {
    interface ClientMainMenuView {
        fun goBackToLogin()
    }
    interface ClientMainMenuPresenter{
        fun exampleMethod()
        fun returnUserName(): String
        fun logOut()
    }
}