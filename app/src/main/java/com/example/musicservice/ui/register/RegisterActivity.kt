package com.example.musicservice.ui.register

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.example.musicservice.R
import com.example.musicservice.ui.login.LoginActivity
import com.example.musicservice.mvpcontract.RegisterContract
import com.example.musicservice.presenter.RegisterPresenter
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_registration.*
import javax.inject.Inject

class RegisterActivity : AppCompatActivity(), RegisterContract.RegisterView{

    @Inject
    private lateinit var presenter : RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        presenter.setView(this)
        setAllActivityComponents()
    }

    private fun setAllActivityComponents() {
        sign_up_registration.setOnClickListener{
            validateInput()
            presenter.onSignUpButtonClicked(
                input_email_login.text.toString(),
                input_password_registration.text.toString(),
                input_username_registration.text.toString())
        }
        sign_in_text_registration.setOnClickListener{
            presenter.onSignInButtonClicked()
        }

    }


    //TODO change it to other activity
    override fun onRegisterSuccess() = startActivity(Intent(this, LoginActivity::class.java))


    override fun showPasswordError() {
        input_password_registration.error = getString(R.string.password_error)
    }

    override fun showEmailError() {
        input_email_registration.error = getString(R.string.email_error)
    }
    override fun onDelegateToLogin() = startActivity(Intent(this, LoginActivity::class.java))


    //TODO validate username
    fun validateInput() {
        if (input_email_login.text.toString().isEmpty()) {
            input_email_login.error = "Please enter email"
            input_email_login.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(input_email_login.text.toString()).matches()) {
            input_email_login.error = "Please enter valid email"
            input_email_login.requestFocus()
            return
        }

        if (input_password_login.text.toString().isEmpty()) {
            input_password_login.error = "Please enter password"
            input_password_login.requestFocus()
            return
        }
    }

}