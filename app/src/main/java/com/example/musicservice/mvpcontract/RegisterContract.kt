package com.example.musicservice.mvpcontract


interface RegisterContract {

    interface RegisterView {
        fun onClientRegisterSuccess(username:String)
        fun onMusicProviderRegisterSuccess(username:String)
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
        fun onCheckboxUsed(userType : String)
    }
}