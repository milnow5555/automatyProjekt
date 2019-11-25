package com.example.musicservice.firebase.auth

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import javax.inject.Inject


//https://medium.com/@cervonefrancesco/model-view-presenter-android-guidelines-94970b430ddf
class FirebaseAuthManagerImpl @Inject constructor(private val authentication: FirebaseAuth): FirebaseAuthManager{

    override fun login(email: String, password: String) : Task<AuthResult>{
        return authentication.signInWithEmailAndPassword(email, password).addOnCompleteListener {
          if(it.isComplete && it.isSuccessful)println("LOGIN------------------------------------------------------succ-")
          else println("LOGIN-----------------------------------------------------noot-succ-")

        }
    }

    override fun register(email: String, password: String, userName: String) : Task<AuthResult>{
        return authentication.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isComplete && it.isSuccessful) {
                authentication.currentUser?.updateProfile(
                    UserProfileChangeRequest
                        .Builder()
                        .setDisplayName(userName)
                        .build()
                )
                println("SUCCESFUL REGISTRATION ${authentication.currentUser?.email}")
            }
        }
    }

    override fun onAuthStateChangesListener(){
        authentication.addAuthStateListener {
            println("STATE ${it.currentUser?.email}")
        }
    }

    override fun getUserId(): String = authentication.currentUser?.uid ?: ""
    override fun getUserName(): String = authentication.currentUser?.displayName ?: ""

    override fun logOut() = authentication.signOut()

}