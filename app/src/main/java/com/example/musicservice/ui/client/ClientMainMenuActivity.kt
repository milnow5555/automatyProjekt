package com.example.musicservice.ui.client

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.musicservice.R
import com.example.musicservice.mvpcontract.client.ClientMainMenuContract

class ClientMainMenuActivity : AppCompatActivity(), ClientMainMenuContract.ClientMainMenuView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_main_menu)
    }

}