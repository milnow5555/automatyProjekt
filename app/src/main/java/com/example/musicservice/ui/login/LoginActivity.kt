package com.example.musicservice.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.musicservice.R
import com.example.musicservice.mvpcontract.LoginContract
import com.example.musicservice.presenter.LoginPresenter
import com.example.musicservice.ui.register.RegisterActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginContract.LoginView{



    private lateinit var presenter : LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter.


        sign_in_login.setOnClickListener{
            loginUser()
        }
        sign_up_login.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }


    }

    override fun showEmailError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showPasswordError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
