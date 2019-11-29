package com.example.musicservice.firebase.dao.client

import com.example.musicservice.firebase.auth.FirebaseAuthManager
import com.example.musicservice.model.Client
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import javax.inject.Inject

class ClientDaoImpl @Inject constructor(private val auth : FirebaseAuthManager, private val database : FirebaseDatabase) : ClientDao{


    private val databaseClientsReference = database.getReference("/Users")

    override fun findByClientCompany(company: String): Client {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findByClientType(type: String): Client {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAll(): List<Client> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun save(client: Client) {
        println("CLIENT DAO SAVE -------------------------------------------------------")
        databaseClientsReference.child("/${auth.getUserId()}").setValue(client)
    }

    override fun getByCurrentUserId(): DatabaseReference {
        return databaseClientsReference.child("/${auth.getUserId()}")
    }

    override fun getByName(name: String): Client {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}