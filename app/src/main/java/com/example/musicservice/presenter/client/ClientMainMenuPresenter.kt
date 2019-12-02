package com.example.musicservice.presenter.client

import com.example.musicservice.firebase.auth.FirebaseAuthManager
import com.example.musicservice.model.MusicProvider
import com.example.musicservice.mvpcontract.client.ClientMainMenuContract
import com.example.musicservice.presenter.BasePresenter
import com.google.firebase.database.FirebaseDatabase
import javax.inject.Inject

class ClientMainMenuPresenter @Inject constructor(private val auth : FirebaseAuthManager, private val database : FirebaseDatabase)
    : BasePresenter<ClientMainMenuContract.ClientMainMenuView>, ClientMainMenuContract.ClientMainMenuPresenter {

    private lateinit var mainmenuView : ClientMainMenuContract.ClientMainMenuView
    override fun setView(view: ClientMainMenuContract.ClientMainMenuView) {
        this.mainmenuView = view
    }
    override fun returnUserName(): String {
        return auth.getUserName()
    }
    override fun logOut() {
        auth.logOut()
        mainmenuView.goBackToLogin()
    }

    override fun initMusicProviders() {
   /*     val reference = database.getReference("/Music")

        var musicProvList : MutableList<MusicProvider> = mutableListOf()

        var first : MusicProvider = MusicProvider(
            id = reference.push().key,
            name = "Green Rock Band",
            active = false,
            city = "Moscow",
            rating = 1.0,
            musicProviderType = "Wedding"
        )
        var second : MusicProvider = MusicProvider(
            id = reference.push().key,
            name = "Yellow Metal Band",
            active = false,
            city = "Sydney",
            rating = 5.0,
            musicProviderType = "Metal"
        )

        musicProvList.addAll(listOf(first,second))

        for(inn in musicProvList){
            reference.child("/${inn.id}").setValue(inn)
        }*/
    }


}