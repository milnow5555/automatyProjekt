package com.example.musicservice.ui.client.profile.personaleventlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.musicservice.MusicApp
import com.example.musicservice.MusicApp.Companion.component
import com.example.musicservice.R
import com.example.musicservice.model.Client
import com.example.musicservice.model.Event
import com.example.musicservice.mvpcontract.client.ClientPersonalEventDetailsContract
import com.example.musicservice.presenter.client.ClientPersonalEventDetailsPresenter

class ClientPersonalEventDetailsActivity : AppCompatActivity(), ClientPersonalEventDetailsContract.CLientPersonalEventDetailsView {

    private val presenter : ClientPersonalEventDetailsPresenter = component.clientPersonalEventDetailsPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_personal_eventdetails)
        presenter.setView(this)
    }

    override fun setEventData(client: Client?) {
        
    }

    override fun setClientData(client: Client?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}