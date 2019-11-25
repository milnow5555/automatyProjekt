package com.example.musicservice.firebase.dao.musicprovider

import com.example.musicservice.model.MusicProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import javax.inject.Inject

class MusicProviderDaoImpl @Inject constructor(private val auth : FirebaseAuth, private val database : FirebaseDatabase) : MusicProviderDao {
    override fun getAll(): List<MusicProvider> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getById(id: Int): MusicProvider {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getByName(name: String): MusicProvider {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}