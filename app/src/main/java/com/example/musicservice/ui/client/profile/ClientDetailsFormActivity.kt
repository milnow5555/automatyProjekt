package com.example.musicservice.ui.client.profile

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.musicservice.MusicApp.Companion.component
import com.example.musicservice.R
import com.example.musicservice.model.Client
import com.example.musicservice.mvpcontract.client.ClientDetailsFormContract
import com.example.musicservice.presenter.client.ClientDetailsFormPresenter
import com.example.musicservice.ui.client.ClientMainMenuActivity
import kotlinx.android.synthetic.main.activity_client_details_form.*

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
            client = Client(name = client_addevent_name.text.toString(), surname = client_addevent_date.text.toString(),
                company = client_addevent_type.text.toString(), description = client_addevent_reward.text.toString(), phone = client_addevent_desc.text.toString())

            presenter.handleForm(client)
        }
    }

    override fun startMainMenuActivity() {
        var intent = Intent(this, ClientMainMenuActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}