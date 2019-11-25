package com.example.musicservice.firebase.auth

interface FirebaseAuthManager {
    fun login(email: String, password: String)
    fun register(email: String, password: String, userName: String)
    fun getUserId(): String
    fun getUserName(): String
    fun logOut()
}