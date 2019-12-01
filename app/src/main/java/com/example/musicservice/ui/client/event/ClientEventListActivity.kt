package com.example.musicservice.ui.client.event

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicservice.MusicApp
import com.example.musicservice.R
import com.example.musicservice.model.Client
import com.example.musicservice.model.Event
import com.example.musicservice.mvpcontract.client.ClientEventListContract
import com.example.musicservice.presenter.client.ClientEventListPresenter
import com.example.musicservice.ui.client.profile.personaleventlist.ClientPersonalEventDetailsActivity
import com.example.musicservice.ui.client.profile.personaleventlist.ClientPersonalEventListRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_client_event_list.*
import kotlinx.android.synthetic.main.activity_client_personal_eventlist.*

class ClientEventListActivity : AppCompatActivity(), ClientEventListContract.ClientEventListView {

    private val presenter : ClientEventListPresenter = MusicApp.component.clientEventListPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_event_list)
        presenter.setView(this)
        eventlist_usernametext_allev.text = presenter.getUsername()
        presenter.obtainAllEvents()
    }

    override fun initializeRecyclerView(clientsEventList: MutableMap<Client?, MutableList<Event?>>) {
        val itemOnClick: (View, Int, String?) -> Unit = { view, position, eventId ->
            onClickedItemView(eventId)
        }

        var clientEventListAdapter : ClientEventListAdapter =
            ClientEventListAdapter(itemOnClick, clientsEventList, mutableListOf(), this)

        client_personal_events_recyclerview_allev.adapter = clientEventListAdapter
        client_personal_events_recyclerview_allev.layoutManager = LinearLayoutManager(this)    }

    override fun onClickedItemView(eventId: String?) {
        var intent : Intent = Intent(this, ClientPersonalEventDetailsActivity::class.java)
        intent.putExtra("eventid", eventId)
        startActivity(intent)
    }

    override fun progressBarReaction() {
        if(client_personal_eventlist_progressbar_allev.visibility == ProgressBar.GONE) client_personal_eventlist_progressbar_allev.visibility = ProgressBar.VISIBLE
        else client_personal_eventlist_progressbar_allev.visibility = ProgressBar.GONE
    }


}