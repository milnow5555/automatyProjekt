package com.example.musicservice.mvpcontract

interface LoginContract {

    interface LoginView {
        fun showEmailError()
        fun showPasswordError()
    }
    interface LoginPresenter {
        fun onSignInButtonClicked()
        fun onSignUpButtonClicked(email:String, password:String, username:String)
    }

}