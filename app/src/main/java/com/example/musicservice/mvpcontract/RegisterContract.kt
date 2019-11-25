package com.example.musicservice.mvpcontract


interface RegisterContract {

    interface RegisterView {
        fun onRegisterSuccess()
        fun onDelegateToLogin()
        fun showEmailError()
        fun showPasswordError()
    }

    interface RegisterPresenter {
        fun onSignInButtonClicked()
        fun onSignUpButtonClicked(email:String, password:String, username:String)
    }
}