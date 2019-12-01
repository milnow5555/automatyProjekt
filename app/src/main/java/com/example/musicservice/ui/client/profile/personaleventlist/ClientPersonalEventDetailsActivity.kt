package com.example.musicservice.ui.client.profile.personaleventlist

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.musicservice.MusicApp
import com.example.musicservice.MusicApp.Companion.component
import com.example.musicservice.R
import com.example.musicservice.model.Client
import com.example.musicservice.model.Event
import com.example.musicservice.mvpcontract.client.ClientPersonalEventDetailsContract
import com.example.musicservice.presenter.client.ClientPersonalEventDetailsPresenter
import kotlinx.android.synthetic.main.activity_client_personal_eventdetails.*
import kotlinx.android.synthetic.main.activity_client_personal_eventlist.*
import kotlinx.android.synthetic.main.layout_listitem_client_personalevents.*

class ClientPersonalEventDetailsActivity : AppCompatActivity(), ClientPersonalEventDetailsContract.CLientPersonalEventDetailsView {

    private val presenter : ClientPersonalEventDetailsPresenter = component.clientPersonalEventDetailsPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_personal_eventdetails)
        presenter.setView(this)
        presenter.loadClientData()

        presenter.loadEventData(intent.getStringExtra("eventid"))
    }

    override fun setEventData(event: Event?) {
        now_event_name.text = event?.eventName
        now_eventreward.text = event?.reward
        now_eventtype.text = event?.eventType
        now_event_date.text = event?.date
        now_event_desc.text = event?.description
    }
    override fun setClientData(client: Client?) {
        now_event_owner.text = client?.username
        eventlist_usernametext_now.text = presenter.getUsername()
    }

    override fun showProgressBar() {
        now_progressbar.visibility = ProgressBar.VISIBLE
    }

    override fun hideProgressBar() {
        now_progressbar.visibility = ProgressBar.GONE
    }

}