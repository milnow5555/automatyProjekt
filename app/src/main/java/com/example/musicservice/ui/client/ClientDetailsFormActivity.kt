package com.example.musicservice.ui.client

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.musicservice.R
import com.example.musicservice.mvpcontract.client.ClientDetailsFormContract

class ClientDetailsFormActivity : AppCompatActivity(), ClientDetailsFormContract.ClientDetailsFormView{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_details_form)
        println("CLIENT DETAILS")
    }
}