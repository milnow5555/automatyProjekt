package com.example.musicservice.presenter

import com.example.musicservice.common.Validator
import com.example.musicservice.firebase.auth.FirebaseAuthManager
import com.example.musicservice.mvpcontract.RegisterContract
import javax.inject.Inject


class RegisterPresenter @Inject constructor(private val auth : FirebaseAuthManager) : BasePresenter<RegisterContract.RegisterView>, RegisterContract.RegisterPresenter {

    private lateinit var view : RegisterContract.RegisterView
    private var userType : String = "client"

    override fun setView(view: RegisterContract.RegisterView) {
        this.view = view
    }

    override fun onSignInButtonClicked() = view.onDelegateToLogin()

    override fun onSignUpButtonClicked(email: String, password: String, username: String) {
        if(inputIsValid(email,password,username)){
           tryToRegister(email, password, username)
        }
    }

    override fun onCheckboxUsed(userType: String) {
        this.userType = userType
    }

    private fun tryToRegister(email: String, password: String, username: String){
        val register = auth.register(email, password, username)
        view.showProgressBar()
        register.addOnCompleteListener{
            auth.onAuthStateChangesListener()
            auth.login(email, password).addOnSuccessListener {
                if(auth.getUserName().isNotEmpty()) {
                    view.hideProgressBar()
                    if(userType == "client") view.onClientRegisterSuccess(username)
                    else view.onMusicProviderRegisterSuccess(username)
                }
            }
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