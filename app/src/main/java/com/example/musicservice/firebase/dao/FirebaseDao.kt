package com.example.musicservice.firebase.dao

interface FirebaseDao<T> {
    fun getAll() : List<T>
    fun getById(id : Int) : T
    fun getByName(name : String) : T
}