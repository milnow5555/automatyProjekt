package com.example.musicservice.ui.client

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.musicservice.MusicApp
import com.example.musicservice.MusicApp.Companion.component
import com.example.musicservice.R
import com.example.musicservice.firebase.auth.FirebaseAuthManager
import com.example.musicservice.mvpcontract.client.ClientMainMenuContract
import com.example.musicservice.presenter.client.ClientMainMenuPresenter
import com.example.musicservice.ui.client.event.ClientEventListActivity
import com.example.musicservice.ui.client.profile.ClientPersonalProfileActivity
import com.example.musicservice.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_client_main_menu.*
import javax.inject.Inject

class ClientMainMenuActivity : AppCompatActivity(), ClientMainMenuContract.ClientMainMenuView {

    private val presenter : ClientMainMenuPresenter = component.clientMainMenuPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_main_menu)
        presenter.setView(this)
        cli_menu_username.text = presenter.returnUserName()

        initAll()
    }

    override fun goBackToLogin() {
        var intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    private fun initAll() {
        activity_client_main_menu_mplist_button2.setOnClickListener{
            presenter.logOut()
        }
        activity_client_main_menu_mplist_button.setOnClickListener{
            startActivity(Intent(this, ClientPersonalProfileActivity::class.java))
        }
        activity_client_main_menu_mplist_button3.setOnClickListener{
            startActivity(Intent(this, ClientEventListActivity::class.java))
        }
    }


}