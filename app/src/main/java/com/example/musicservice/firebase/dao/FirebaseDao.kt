package com.example.musicservice.firebase.dao

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

interface FirebaseDao<T> {
    fun getAll() : List<T>
    fun getByCurrentUserId() : DatabaseReference
    fun getByName(name : String) : T
    fun save(t : T)
}