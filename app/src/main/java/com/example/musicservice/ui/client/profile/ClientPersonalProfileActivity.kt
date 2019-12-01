package com.example.musicservice.ui.client.profile

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.musicservice.MusicApp.Companion.component
import com.example.musicservice.R
import com.example.musicservice.model.Client
import com.example.musicservice.mvpcontract.client.ClientPersonalProfileContract
import com.example.musicservice.presenter.client.ClientPersonalProfilePresenter
import com.example.musicservice.ui.client.profile.personaleventlist.ClientPersonalEventListActivity
import kotlinx.android.synthetic.main.activity_client_personal_profile.*

class ClientPersonalProfileActivity : AppCompatActivity(), ClientPersonalProfileContract.ClientPersonalProfileView {

    private val presenter : ClientPersonalProfilePresenter = component.clientPersonalProfilePresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_personal_profile)
        presenter.setView(this)

        myevents.setOnClickListener{
            startActivity(Intent(this, ClientPersonalEventListActivity::class.java))
        }
        editprofile.setOnClickListener{
            startActivity(Intent(this, ClientPersonalProfileEditActivity::class.java))
        }
    }
    override fun setClientPersonalProfileData(client : Client?) {
        client_profile_email.text = client?.email ?: "BRAK"
        client_profile_username.text = client?.username ?: "BRAK"
        now_event_date.text = client?.phone ?: "BRAK"
        client_profile_company.text = client?.company ?: "BRAK"
        client_profile_nameandsurname.text = "${client?.name} ${client?.surname}"
    }

    override fun showProgressBar() {
        client_details_progressbar.visibility = ProgressBar.VISIBLE
    }

    override fun hideProgressBar() {
        client_details_progressbar.visibility = ProgressBar.GONE
    }
}