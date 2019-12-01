package com.example.musicservice.firebase.dao.musicprovider

import com.example.musicservice.model.Client
import com.example.musicservice.model.Event
import com.example.musicservice.model.MusicProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.LinkedHashMap
import javax.inject.Inject

class MusicProviderDaoImpl @Inject constructor(private val auth : FirebaseAuth, private val database : FirebaseDatabase) : MusicProviderDao {
    override fun save(t: MusicProvider) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAll(viewInvoker: (linkedMapOf: LinkedHashMap<Client?, MutableList<Event?>>) -> Unit, progressBarInvoker : () -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getByCurrentUserId(): DatabaseReference {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getByName(name: String): MusicProvider {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}