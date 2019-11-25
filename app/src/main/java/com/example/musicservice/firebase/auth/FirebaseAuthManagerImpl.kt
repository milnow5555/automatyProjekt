package com.example.musicservice.firebase.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import javax.inject.Inject

class FirebaseAuthManagerImpl @Inject constructor(private val authentication: FirebaseAuth): FirebaseAuthManager{

    override fun login(email: String, password: String) {
        println("LOGIN-------------------------------------------------------")
        authentication.signInWithEmailAndPassword(email, password).addOnCompleteListener {
          if(it.isComplete && it.isSuccessful){
              println("LOGIN------------------------------------------------------succ-")
          }
          else{
              println("LOGIN-----------------------------------------------------noot-succ-")
          }
        }
    }

    override fun register(email: String, password: String, userName: String) {
        println("USER BEFOR nd user = ${authentication.currentUser?.email}" )
        authentication.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isComplete && it.isSuccessful) {
                authentication.currentUser?.updateProfile(
                    UserProfileChangeRequest
                    .Builder()
                    .setDisplayName(userName)
                    .build())
                println("SUCCESFUL REGISTRATION")
                login(email, password)
            }else {
                println("NOT SUCCESFUL REGISTRATION")
            }
        }
        println("USER AFTER nd user = ${authentication.currentUser?.email}" )
    }

    fun onAuthStateChanges(){
        authentication.addAuthStateListener {  }
    }

    override fun getUserId(): String = authentication.currentUser?.uid ?: ""
    override fun getUserName(): String = authentication.currentUser?.displayName ?: ""

    override fun logOut() = authentication.signOut()

}