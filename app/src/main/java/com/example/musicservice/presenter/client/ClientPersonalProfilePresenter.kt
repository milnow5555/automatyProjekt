package com.example.musicservice.presenter.client

import com.example.musicservice.firebase.auth.FirebaseAuthManager
import com.example.musicservice.firebase.dao.client.ClientDao
import com.example.musicservice.model.Client
import com.example.musicservice.mvpcontract.client.ClientPersonalProfileContract
import com.example.musicservice.presenter.BasePresenter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import javax.inject.Inject

class ClientPersonalProfilePresenter  @Inject constructor(private val auth : FirebaseAuthManager, private val clientDao: ClientDao) : BasePresenter<ClientPersonalProfileContract.ClientPersonalProfileView>, ClientPersonalProfileContract.ClientPersonalProfilePresenter {
    private lateinit var view : ClientPersonalProfileContract.ClientPersonalProfileView
    override fun setView(view: ClientPersonalProfileContract.ClientPersonalProfileView) {
        this.view = view
        setClientInfo()
    }

    private fun setClientInfo() {
        val concreteUser = clientDao.getByCurrentUserId()
        var client : Client?
        view.showProgressBar()

        concreteUser.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if(dataSnapshot.exists()) {
                    client = dataSnapshot.getValue(Client::class.java)
                    println("ASYNC KURWO----------------------------- ${client}")
                    view.hideProgressBar()
                    view.setClientPersonalProfileData(client)
                }
            }
        })


    }


    override fun myEvents() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun editProfile() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}