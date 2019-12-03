package com.example.musicservice.firebase.dao.musicprovider

import com.example.musicservice.model.Client
import com.example.musicservice.model.Event
import com.example.musicservice.model.MusicProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.util.LinkedHashMap
import javax.inject.Inject

class MusicProviderDaoImpl @Inject constructor(private val auth : FirebaseAuth, private val database : FirebaseDatabase) : MusicProviderDao {

    private val databaseMusicProv = database.getReference("/Music")

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

    override fun getAllMusicProv(viewInvoker: (listOfProviders: MutableList<MusicProvider?>) -> Unit, progressBarInvoker: () -> Unit) {
        progressBarInvoker.invoke()
        databaseMusicProv.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                println("Error")
            }

            override fun onDataChange(musicProviders: DataSnapshot) {
                val listOfMps : MutableList<MusicProvider?> = mutableListOf()
                for (snap in musicProviders.children){
                    listOfMps.add(snap.getValue(MusicProvider::class.java))
                }
                progressBarInvoker.invoke()
                viewInvoker.invoke(listOfMps)
            }
        })
    }

    override fun getAllMusicProv(allFeaturesBankFullfillment: (MutableSet<MusicProvider>) -> Unit) {
        databaseMusicProv.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                println("Error")
            }

            override fun onDataChange(musicProviders: DataSnapshot) {
                val listOfMps : MutableList<MusicProvider?> = mutableListOf()
                for (snap in musicProviders.children){
                    listOfMps.add(snap.getValue(MusicProvider::class.java))
                }
                val toMutableSet = listOfMps.toMutableSet()
                val map = listOfMps.map { it!! }.toMutableSet()

                allFeaturesBankFullfillment.invoke(map)
            }
        })
    }

}