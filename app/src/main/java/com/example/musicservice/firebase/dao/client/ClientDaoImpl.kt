package com.example.musicservice.firebase.dao.client

import com.example.musicservice.firebase.auth.FirebaseAuthManager
import com.example.musicservice.model.Client
import com.example.musicservice.model.Event
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.util.LinkedHashMap
import javax.inject.Inject

class ClientDaoImpl @Inject constructor(private val auth : FirebaseAuthManager, private val database : FirebaseDatabase) : ClientDao{


    private val databaseClientsReference = database.getReference("/Users")

    override fun findByClientCompany(company: String): Client {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findByClientType(type: String): Client {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAll(viewInvoker: (linkedMapOf: LinkedHashMap<Client?, MutableList<Event?>>) -> Unit, progressBarInvoker : () -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun save(client: Client) {
        databaseClientsReference.child("/${auth.getUserId()}").setValue(client)
    }

    override fun getByCurrentUserId(): DatabaseReference {
        return databaseClientsReference.child("/${auth.getUserId()}")
    }

    override fun getByName(name: String): Client {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun updateClient(client : Client) {
        val userReference = databaseClientsReference.child("${auth.getUserId()}")
        if(client.company != "") {
            val child = userReference.child("company")
            child.setValue(client.company)
        }
        if (client.phone != "") {
            val child = userReference.child("phone")
            child.setValue(client.phone)
        }
        if(client.name != "") {
            val child = userReference.child("name")
            child.setValue(client.name)
        }
        if(client.surname != "") {
            val child = userReference.child("surname")
            child.setValue(client.surname)
        }
    }


}