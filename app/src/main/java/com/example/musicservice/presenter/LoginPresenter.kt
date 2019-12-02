package com.example.musicservice.presenter

import android.widget.Toast
import com.example.musicservice.common.Validator
import com.example.musicservice.firebase.auth.FirebaseAuthManager
import com.example.musicservice.model.MusicProvider
import com.example.musicservice.mvpcontract.LoginContract
import com.google.firebase.database.FirebaseDatabase
import timber.log.Timber
import javax.inject.Inject

class LoginPresenter @Inject constructor(private val auth : FirebaseAuthManager, private var database: FirebaseDatabase) : BasePresenter<LoginContract.LoginView>, LoginContract.LoginPresenter {

    private lateinit var view : LoginContract.LoginView
    override fun setView(view: LoginContract.LoginView) {
        this.view = view
    }
    override fun initLogOut() {
        auth.logOut()
    }
    override fun onSignInButtonClicked(email: String, password: String) {
        if(inputIsValid(email, password)){
            view.showProgressBar()
            auth.login(email, password).addOnSuccessListener  {
                /*TODO delegating to appropriate main menu
                *  onMusicProviderLoginSuccess()*/
                println(auth.getUserName())
                view.onClientLoginSuccess()
                view.hideProgressBar()
                 }.addOnFailureListener {
                view.onLoginFailedToast()
                view.hideProgressBar()
                }
        }
    }

    override fun initMusicProviders() {

    }

    override fun onSignUpButtonClicked() = view.delegateToRegistrationActivity()

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