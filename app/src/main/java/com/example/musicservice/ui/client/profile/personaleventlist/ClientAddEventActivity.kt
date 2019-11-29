package com.example.musicservice.ui.client.profile.personaleventlist

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.musicservice.MusicApp.Companion.component
import com.example.musicservice.R
import com.example.musicservice.model.Event
import com.example.musicservice.mvpcontract.client.ClientAddEventContract
import com.example.musicservice.presenter.client.ClientAddEventPresenter
import com.example.musicservice.ui.client.ClientMainMenuActivity
import kotlinx.android.synthetic.main.activity_client_add_event.*
import kotlinx.android.synthetic.main.activity_client_personal_profile.*

class ClientAddEventActivity : AppCompatActivity(), ClientAddEventContract.ClientAddEventView{

    private val presenter : ClientAddEventPresenter = component.clientAddEventPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_add_event)
        presenter.setView(this)
        addevent_usernametext.text = presenter.getUsername()

        floatingActionButton2.setOnClickListener{
            showProgressBar()
            var event : Event = Event(eventName = client_addevent_name.text.toString(),
                date = client_addevent_date.text.toString(),
                description = client_addevent_desc.text.toString(),
                ownerId = presenter.getUserId(),
                reward = client_addevent_reward.text.toString(),
                eventType = client_addevent_type.text.toString())
            presenter.handleEventForm(event)
            hideProgressBar()
            onAddEventSuccess()
        }
    }

    override fun onAddEventSuccess() {
        var intent = Intent(this, ClientMainMenuActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    override fun showProgressBar() {
        client_details_progressbar.visibility = ProgressBar.VISIBLE
    }

    override fun hideProgressBar() {
        client_details_progressbar.visibility = ProgressBar.GONE
    }


}