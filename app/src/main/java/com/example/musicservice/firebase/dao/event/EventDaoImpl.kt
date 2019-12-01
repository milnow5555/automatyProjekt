package com.example.musicservice.firebase.dao.event

import com.example.musicservice.firebase.auth.FirebaseAuthManager
import com.example.musicservice.model.Client
import com.example.musicservice.model.Event
import com.example.musicservice.mvpcontract.client.ClientPersonalEventListContract
import com.google.firebase.database.*
import java.util.LinkedHashMap
import java.util.concurrent.CompletableFuture
import javax.inject.Inject

class EventDaoImpl  @Inject constructor(private val auth : FirebaseAuthManager, private val database : FirebaseDatabase)  : EventDao {


    private val databaseEventsReference = database.getReference("/Events")

    override fun getAll(viewInvoker: (linkedMapOf: LinkedHashMap<Client?, MutableList<Event?>>) -> Unit, progressBarInvoker : () -> Unit){
        progressBarInvoker.invoke()
        databaseEventsReference.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                println("================================================ DATABASE ERROR ==========================================================")
            }

            override fun onDataChange(datasnapshot: DataSnapshot) {
                val listOfEvents: MutableList<Event?> = mutableListOf()
                for (snap in datasnapshot.children) {
                    listOfEvents.add(snap.getValue(Event::class.java))
                }
                val clientDbRef = database.getReference("/Users")

                var foreverMap: LinkedHashMap<String, MutableList<Event?>> =
                    linkedMapOf()

                listOfEvents.forEach{
                    foreverMap.put(it!!.ownerId,listOfEvents.filter { event -> event!!.ownerId == it!!.ownerId }!!.toMutableList())
                }



                var linkedHashMapToReturn: LinkedHashMap<String, MutableList<Event?>> =
                    linkedMapOf()
                foreverMap.keys.forEach { id ->
                    linkedHashMapToReturn.put(id, listOfEvents.filter { event ->
                        event?.ownerId == id
                    }.toMutableList())
                }
                clientDbRef.addValueEventListener(object : ValueEventListener {
                    override fun onCancelled(p0: DatabaseError) {
                        println("================================================ DATABASE ERROR ==========================================================")
                    }

                    override fun onDataChange(clients: DataSnapshot) {

                        var aginHashMap: LinkedHashMap<Client?, MutableList<Event?>> =
                            linkedMapOf()
                        linkedHashMapToReturn.keys.forEach{
                            aginHashMap.put(clients.child(it).getValue(Client::class.java), linkedHashMapToReturn.getValue(it))
                        }
                        progressBarInvoker.invoke()
                        viewInvoker.invoke(aginHashMap)
                    }
                })

            }
        })
    }

    override fun getAllEventsByClientId(clientId: String, clientPersonalEventListView : ClientPersonalEventListContract.ClientPersonalEventListView){
        clientPersonalEventListView.showProgressBar()
        databaseEventsReference.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                println("================================================ DATABASE ERROR ==========================================================")
            }

            override fun onDataChange(datasnapshot: DataSnapshot) {
                val listOfEvents : MutableList<Event?> = mutableListOf()
                for (snap in datasnapshot.children){
                        listOfEvents.add(snap.getValue(Event::class.java))
                }
                val specificUserEvents =
                    listOfEvents.filter { event -> event?.ownerId == auth.getUserId() }
                        .toMutableList()
                val linkedMapOf: LinkedHashMap<String, MutableList<Event?>> =
                    linkedMapOf(auth.getUserName() to specificUserEvents)

                clientPersonalEventListView.hideProgressBar()
                clientPersonalEventListView.initializeRecyclerView(linkedMapOf)
            }
        })
    }

    override fun getByCurrentUserId(): DatabaseReference {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getByName(name: String): Event {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getById(eventId : String) = databaseEventsReference.child("/${eventId}")

    override fun save(savable : Event) {
        val key = databaseEventsReference.push().key
        savable.eventId = key
        databaseEventsReference.child("/${key}").setValue(savable)
    }
}