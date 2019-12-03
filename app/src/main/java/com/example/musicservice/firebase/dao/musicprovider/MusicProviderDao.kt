package com.example.musicservice.firebase.dao.musicprovider

import com.example.musicservice.firebase.dao.FirebaseDao
import com.example.musicservice.model.MusicProvider

interface MusicProviderDao : FirebaseDao<MusicProvider> {
    fun getAllMusicProv(viewInvoker : (mapOfEvents:MutableList<MusicProvider?>) -> Unit, progressBarInvoker : () -> Unit)
    fun getAllMusicProv(nameBankFulfillment : (MutableSet<MusicProvider>) -> Unit)
}