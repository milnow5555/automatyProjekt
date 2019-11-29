package com.example.musicservice.firebase.dao.event

import com.example.musicservice.firebase.auth.FirebaseAuthManager
import com.example.musicservice.model.Event
import com.example.musicservice.mvpcontract.client.ClientPersonalEventListContract
import com.google.firebase.database.*
import java.util.concurrent.CompletableFuture
import javax.inject.Inject

class EventDaoImpl  @Inject constructor(private val auth : FirebaseAuthManager, private val database : FirebaseDatabase)  : EventDao {
    private val databaseEventsReference = database.getReference("/Events")

    override fun getAll(): List<Event> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllEventsByClientId(clientId: String, clientPersonalEventListView : ClientPersonalEventListContract.ClientPersonalEventListView){
        clientPersonalEventListView.showProgressBar()
        databaseEventsReference.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(datasnapshot: DataSnapshot) {
                println("-----------EVENT DAO IMPL FIND ALL EVENTS BY ID ------------- + ${auth.getUserId()}")
                val listOfEvents : MutableList<Event?> = mutableListOf()
                for (snap in datasnapshot.children){
                    if(snap.child("clientId").toString()==auth.getUserId()){
                        println("------------------ZNALAZLEM EVENT DLA ${auth.getUserId()}")
                        listOfEvents.add(snap.getValue(Event::class.java))
                    }
                }
                clientPersonalEventListView.hideProgressBar()
                clientPersonalEventListView.initializeRecyclerView(listOfEvents)
            }
        })

    }

    override fun getByCurrentUserId(): DatabaseReference {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getByName(name: String): Event {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun save(savable : Event) {
        println("EVENT DAO SAVE -------------------------------------------------------")

        val key = databaseEventsReference.push().key
        println("EVENT DAO KEY ---------------------------- ${key}")
        databaseEventsReference.child("/${key}").setValue(savable)
    }
}