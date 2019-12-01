package com.example.musicservice.firebase.dao

import com.example.musicservice.model.Client
import com.example.musicservice.model.Event
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import java.util.LinkedHashMap

interface FirebaseDao<T> {
    fun getAll(viewInvoker: (linkedMapOf: LinkedHashMap<Client?, MutableList<Event?>>) -> Unit, progressBarInvoker : () -> Unit)
    fun getByCurrentUserId() : DatabaseReference
    fun getByName(name : String) : T
    fun save(savable : T)
}