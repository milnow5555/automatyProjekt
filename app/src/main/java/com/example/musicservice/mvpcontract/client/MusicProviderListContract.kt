package com.example.musicservice.mvpcontract.client

import com.example.musicservice.model.MusicProvider

interface MusicProviderListContract {
    interface MusicProviderListView {
        fun initializeRecyclerView(musicProviderList : MutableList<MusicProvider?>)
        fun progressBarReaction()
    }

    interface MusicProviderListPresenter {
        fun obtainAllMusicProviders(name : Boolean, rating : Boolean, city : Boolean, active : Boolean)
        fun getUsername(): String
        fun findByName(it: String)
        fun filterByFeatures(mapOfFeatures: MutableMap<String, String>)
    }
}