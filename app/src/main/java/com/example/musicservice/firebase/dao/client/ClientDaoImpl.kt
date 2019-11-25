package com.example.musicservice.firebase.dao.client

import com.example.musicservice.model.Client
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import javax.inject.Inject

class ClientDaoImpl @Inject constructor(private val auth : FirebaseAuth, private val database : FirebaseDatabase) : ClientDao{
    override fun findByClientCompany(company: String): Client {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findByClientType(type: String): Client {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAll(): List<Client> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getById(id: Int): Client {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getByName(name: String): Client {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}