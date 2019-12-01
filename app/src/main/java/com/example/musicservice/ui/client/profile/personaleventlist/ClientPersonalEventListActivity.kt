package com.example.musicservice.ui.client.profile.personaleventlist

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
import com.example.musicservice.mvpcontract.client.ClientPersonalEventListContract
import com.example.musicservice.presenter.client.ClientPersonalEventListPresenter
import kotlinx.android.synthetic.main.activity_client_personal_eventlist.*

class ClientPersonalEventListActivity : AppCompatActivity(), ClientPersonalEventListContract.ClientPersonalEventListView{

    private val presenter : ClientPersonalEventListPresenter = MusicApp.component.clientPersonalEventListPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_personal_eventlist)
        presenter.setView(this)
        eventlist_usernametext.text = presenter.getUsername()
        floatingActionButton.setOnClickListener{
            startActivity(Intent(this, ClientAddEventActivity::class.java))
        }
        presenter.getAllPersonalEvents()
    }

    override fun initializeRecyclerView(clientsEventList : MutableMap<String, MutableList<Event?>>) {
        val itemOnClick: (View, Int, String?) -> Unit = { view, position, eventId ->
            onItemClickedInRecyclerView(eventId)
        }

        var clientPersonalEventListRecyclerViewAdapter : ClientPersonalEventListRecyclerViewAdapter =
            ClientPersonalEventListRecyclerViewAdapter(itemOnClick, clientsEventList, mutableListOf(), this)

        client_personal_events_recyclerview.adapter = clientPersonalEventListRecyclerViewAdapter
        client_personal_events_recyclerview.layoutManager = LinearLayoutManager(this)
    }

    override fun onItemClickedInRecyclerView(eventId : String?) {
        var intent : Intent = Intent(this, ClientPersonalEventDetailsActivity::class.java)
        intent.putExtra("eventid", eventId)
        startActivity(intent)
    }



    override fun showProgressBar() {
        client_personal_eventlist_progressbar.visibility = ProgressBar.VISIBLE
    }

    override fun hideProgressBar() {
        client_personal_eventlist_progressbar.visibility = ProgressBar.GONE
    }
}