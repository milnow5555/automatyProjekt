package com.example.musicservice.ui.client

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.musicservice.R
import com.example.musicservice.firebase.auth.FirebaseAuthManager
import com.google.firebase.database.FirebaseDatabase
import javax.inject.Inject

class ClientDetailsRegistrationFormActivity @Inject constructor(firebaseAuthManager: FirebaseAuthManager) : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_delegation_client)
        println("CLIENT DETAILS")
    }
}