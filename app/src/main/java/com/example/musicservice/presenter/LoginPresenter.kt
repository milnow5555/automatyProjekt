package com.example.musicservice.presenter

import com.example.musicservice.mvpcontract.LoginContract

class LoginPresenter : BasePresenter<LoginContract.LoginView>, LoginContract.LoginPresenter {

    private lateinit var view : LoginContract.LoginView
    override fun setView(view: LoginContract.LoginView) {
        this.view = view
    }



}