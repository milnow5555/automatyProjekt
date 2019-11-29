package com.example.musicservice.ui.client.profile

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.musicservice.MusicApp
import com.example.musicservice.MusicApp.Companion.component
import com.example.musicservice.R
import com.example.musicservice.firebase.auth.FirebaseAuthManager
import com.example.musicservice.firebase.dao.client.ClientDao
import com.example.musicservice.firebase.dao.client.ClientDaoImpl
import com.example.musicservice.firebase.dao.musicprovider.MusicProviderDao
import com.example.musicservice.model.Client
import com.example.musicservice.mvpcontract.client.ClientDetailsFormContract
import com.example.musicservice.presenter.client.ClientDetailsFormPresenter
import com.example.musicservice.ui.client.ClientMainMenuActivity
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_client_details_form.*
import javax.inject.Inject
import com.example.musicservice.MusicApp.Companion as MusicApp1

class ClientDetailsFormActivity  : AppCompatActivity(), ClientDetailsFormContract.ClientDetailsFormView{

    private val presenter : ClientDetailsFormPresenter = component.clientDetailsFormPresenter()

    private lateinit var client : Client

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_details_form)
        presenter.setView(this)
        println("CLIENT DETAILS")

        nametext.text = presenter.returnUserName()
        client_details_button.setOnClickListener{
            client = Client(name = client_details_name.text.toString(), surname = client_details_surname.text.toString(),
                company = client_details_company.text.toString(), description = client_detalis_desc.text.toString(), phone = client_details_phone.text.toString())

            presenter.handleForm(client)
        }
    }

    override fun startMainMenuActivity() {
        var intent = Intent(this, ClientMainMenuActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}