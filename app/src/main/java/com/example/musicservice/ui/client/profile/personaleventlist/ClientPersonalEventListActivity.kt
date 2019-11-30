package com.example.musicservice.ui.client.profile.personaleventlist

import android.content.Intent
import android.os.Bundle
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
        println("RECYCLER VIEW ACTIVITY PERSONAL EVENT LIST")
        eventlist_usernametext.text = presenter.getUsername()
        floatingActionButton.setOnClickListener{
            startActivity(Intent(this, ClientAddEventActivity::class.java))
        }
        presenter.getAllPersonalEvents()
    }

    override fun initializeRecyclerView(clientsEventList : MutableMap<String, MutableList<Event?>>) {
        println("RECYCLER VIEW INITIALIZATION")


        var clientPersonalEventListRecyclerViewAdapter : ClientPersonalEventListRecyclerViewAdapter =
            ClientPersonalEventListRecyclerViewAdapter(clientsEventList, mutableListOf(), this)
        client_personal_events_recyclerview.adapter = clientPersonalEventListRecyclerViewAdapter
        client_personal_events_recyclerview.layoutManager = LinearLayoutManager(this)
    }


    override fun showProgressBar() {
        client_personal_eventlist_progressbar.visibility = ProgressBar.VISIBLE
    }

    override fun hideProgressBar() {
        client_personal_eventlist_progressbar.visibility = ProgressBar.GONE
    }
}