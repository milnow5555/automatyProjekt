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
       /* val reference = database.getReference("/Music")

        var musicProvList : MutableList<MusicProvider> = mutableListOf()

        var first : MusicProvider = MusicProvider(
            id = reference.push().key,
            name = "First Orchestra",
            active = true,
            city = "Cracow",
            rating = 3.0,
            musicProviderType = "Classical"
        )
        var second : MusicProvider = MusicProvider(
            id = reference.push().key,
            name = "Second Orchestra",
            active = true,
            city = "Warsaw",
            rating = 3.0,
            musicProviderType = "Classical"
        )
        var third : MusicProvider = MusicProvider(
            id = reference.push().key,
            name = "First Jazz Band",
            active = true,
            city = "New York",
            rating = 3.0,
            musicProviderType = "Jazz"
        )
        var fourth : MusicProvider = MusicProvider(
            id = reference.push().key,
            name = "Third Orchestra",
            active = true,
            city = "Berlin",
            rating = 4.0,
            musicProviderType = "Classical"
        )
        var fifth : MusicProvider = MusicProvider(
            id = reference.push().key,
            name = "Fourth Orchestra",
            active = true,
            city = "Paris",
            rating = 3.5,
            musicProviderType = "Classical"
        )
        var sixth : MusicProvider = MusicProvider(
            id = reference.push().key,
            name = "First Metal Band",
            active = true,
            city = "Paris",
            rating = 2.0,
            musicProviderType = "Metal"
        )
        var seventh : MusicProvider = MusicProvider(
            id = reference.push().key,
            name = "Second Jazz Band",
            active = true,
            city = "Barcelona",
            rating = 3.0,
            musicProviderType = "Jazz"
        )
        var ble : MusicProvider = MusicProvider(
            id = reference.push().key,
            name = "Wedding Band",
            active = true,
            city = "Cracow",
            rating = 5.0,
            musicProviderType = "Wedding"
        )
        var ble2 : MusicProvider = MusicProvider(
            id = reference.push().key,
            name = "Folk Band",
            active = true,
            city = "Chrząszczyżewoszyce",
            rating = 3.0,
            musicProviderType = "Folk"
        )

        musicProvList.addAll(listOf(ble,ble2,first,second,third,fourth,fifth,sixth,seventh))

        for(inn in musicProvList){
            reference.child("/${inn.id}").setValue(inn)
        }*/
    }


}