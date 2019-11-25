package com.example.musicservice.firebase.auth

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface FirebaseAuthManager {
    fun login(email: String, password: String) : Task<AuthResult>
    fun register(email: String, password: String, userName: String) : Task<AuthResult>
    fun getUserId(): String
    fun getUserName(): String
    fun logOut()
    fun onAuthStateChangesListener()
}