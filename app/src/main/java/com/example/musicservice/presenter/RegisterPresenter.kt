package com.example.musicservice.presenter

import android.widget.Toast
import com.example.musicservice.common.Validator
import com.example.musicservice.firebase.auth.FirebaseAuthManager
import com.example.musicservice.mvpcontract.RegisterContract
import javax.inject.Inject


//TODO add method onCheckboxSigned
class RegisterPresenter @Inject constructor(private val auth : FirebaseAuthManager) : BasePresenter<RegisterContract.RegisterView>, RegisterContract.RegisterPresenter {

    private lateinit var view : RegisterContract.RegisterView

    override fun setView(view: RegisterContract.RegisterView) {
        this.view = view
    }

    override fun onSignInButtonClicked() = view.onDelegateToLogin()


    override fun onSignUpButtonClicked(email: String, password: String, username: String) {

        if(inputIsValid(email,password,username)){
           tryToRegister(email, password, username)
        }
        /*
        * TODO
        *   if checkbox = true view.delegate to MusicProviderDdetails else ClientDetails
        * */
    }

    private fun tryToRegister(email: String, password: String, username: String){
        auth.register(email, password, username)
        if(!auth.getUserName().isEmpty()) {
            println("DELEGATION SUCCESS")
            view.onRegisterSuccess()
        } else{
            println("DELEGATION FALIURE")
            view.onFailRegistration()
        }
    }

    private fun inputIsValid(email: String, password: String, username: String) : Boolean {
        if(!Validator.isEmailValid(email)) {
            view.showEmailError()
            return false
        }
        else if (!Validator.isPasswordValid(password)) {
            view.showPasswordError()
            return false
        }
        else if (!Validator.isUsernameValid(username)) {
            view.showUsernameError()
            return false
        } else return true
    }


}