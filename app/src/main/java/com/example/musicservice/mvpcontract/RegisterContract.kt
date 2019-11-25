package com.example.musicservice.mvpcontract


interface RegisterContract {

    interface RegisterView {
        fun onRegisterSuccess()
        fun onDelegateToLogin()
        fun showEmailError()
        fun showPasswordError()
        fun showUsernameError()
        fun onFailRegistration()
        fun showProgressBar()
        fun hideProgressBar()
    }

    interface RegisterPresenter {
        fun onSignInButtonClicked()
        fun onSignUpButtonClicked(email:String, password:String, username:String)
    }
}