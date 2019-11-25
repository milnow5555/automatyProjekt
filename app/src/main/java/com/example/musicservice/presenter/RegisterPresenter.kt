package com.example.musicservice.presenter

import com.example.musicservice.firebase.auth.FirebaseAuthManager
import com.example.musicservice.mvpcontract.LoginContract
import com.example.musicservice.mvpcontract.RegisterContract
import javax.inject.Inject

class RegisterPresenter @Inject constructor(private val auth : FirebaseAuthManager) : BasePresenter<RegisterContract.RegisterView>, RegisterContract.RegisterPresenter {

    private lateinit var view : RegisterContract.RegisterView

    override fun setView(view: RegisterContract.RegisterView) {
        this.view = view;
    }

    override fun onSignInButtonClicked() = view.onDelegateToLogin()

    override fun onSignUpButtonClicked(email: String, password: String, username: String) {
        auth.register(email, password, username)
    }



}