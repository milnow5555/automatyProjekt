package com.example.musicservice.firebase.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import javax.inject.Inject

class FirebaseAuthManagerImpl @Inject constructor(private val authentication: FirebaseAuth): FirebaseAuthManager{

    override fun login(email: String, password: String) {
        authentication.signInWithEmailAndPassword(email, password).addOnCompleteListener {
          if(it.isComplete && it.isSuccessful) println("SUCCESSFUL -------------")
          else println("NOT SUCCESSFUL -------------")
        }
    }

    override fun register(email: String, password: String, userName: String) {
        authentication.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isComplete && it.isSuccessful) {
                authentication.currentUser?.updateProfile(
                    UserProfileChangeRequest
                    .Builder()
                    .setDisplayName(userName)
                    .build())
                println("SUCCESSFUL -------------")
            } else {
                println("NOT SUCCESSFUL -------------")
            }
        }
    }

    override fun getUserId(): String = authentication.currentUser?.uid ?: ""
    override fun getUserName(): String = authentication.currentUser?.displayName ?: ""

    override fun logOut() = authentication.signOut()

}