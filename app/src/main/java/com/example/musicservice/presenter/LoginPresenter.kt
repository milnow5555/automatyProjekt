package com.example.musicservice.presenter

import com.example.musicservice.common.Validator
import com.example.musicservice.firebase.auth.FirebaseAuthManager
import com.example.musicservice.mvpcontract.LoginContract
import timber.log.Timber
import javax.inject.Inject

class LoginPresenter @Inject constructor(private val auth : FirebaseAuthManager) : BasePresenter<LoginContract.LoginView>, LoginContract.LoginPresenter {

    private lateinit var view : LoginContract.LoginView
    override fun setView(view: LoginContract.LoginView) {
        this.view = view
    }
    override fun initLogOut() {
        auth.logOut()
    }
    override fun onSignInButtonClicked(email: String, password: String) {
        Timber.i("LOGIN PRESENTER BEFORE VALIDATION")
        if(inputIsValid(email, password)){
            Timber.i("LOGIN PRESENTER AFTER VALIDATION")
            auth.login(email, password)
        }
        /*TODO delegating to appropriate main menu*/
    }

    override fun onSignUpButtonClicked() = view.delegateToRegistrationActivity()

    override fun onLoginSuccess() = view.onLoginSuccess()


    private fun inputIsValid(email: String, password: String) : Boolean {
        if(!Validator.isEmailValid(email)) {
            view.showEmailError()
            return false
        }
        else if (!Validator.isPasswordValid(password)) {
            view.showPasswordError()
            return false
        } else return true
    }

}