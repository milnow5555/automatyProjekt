package com.example.musicservice.ui.client.profile

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.musicservice.MusicApp
import com.example.musicservice.R
import com.example.musicservice.model.Client
import com.example.musicservice.mvpcontract.client.ClientPersonalProfileEditContract
import com.example.musicservice.presenter.client.ClientPersonalProfileEditPresenter
import kotlinx.android.synthetic.main.activity_client_personal_profile_edit.*

class ClientPersonalProfileEditActivity : AppCompatActivity(), ClientPersonalProfileEditContract.ClientPersonalProfileEditView {

    private val presenter : ClientPersonalProfileEditPresenter = MusicApp.component.clientPersonalProfileEditPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_personal_profile_edit)
        presenter.setView(this)
        client_persprof_edit_usernamee.text = presenter.getUsername()
        client_details_edit_butt.setOnClickListener{
            val client : Client = Client(
                 company = client_edit_company.text.toString()
                ,name = client_edit_name.text.toString()
                ,surname = client_edit_surname.text.toString()
                ,phone = client_edit_desc.text.toString())
            presenter.updateProfile(client)
            startActivity(Intent(this,ClientPersonalProfileActivity::class.java))
        }
    }

}