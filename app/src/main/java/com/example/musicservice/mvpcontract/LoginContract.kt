package com.example.musicservice.mvpcontract

interface LoginContract {

    interface LoginView {
        fun showEmailError()
        fun showPasswordError()
        fun onClientLoginSuccess()
        fun onMusicProviderLoginSuccess()
        fun delegateToRegistrationActivity()
        fun onLoginFailedToast()
        fun showProgressBar()
        fun hideProgressBar()
    }
    interface LoginPresenter {
        fun onSignInButtonClicked(email:String, password:String)
        fun onSignUpButtonClicked()
        fun initLogOut()
        fun initMusicProviders()
    }

}