package com.example.musicservice.searchingmodule

import com.example.musicservice.firebase.dao.musicprovider.MusicProviderDao
import com.example.musicservice.model.MusicProvider
import java.io.Serializable
import javax.inject.Inject

class KeywordsBank @Inject constructor(private val musicProviderDao: MusicProviderDao) : Serializable{

    var nameMutableSet : MutableSet<String> = mutableSetOf()
    var rateMutableSet : MutableSet<String> = mutableSetOf()
    var typeMutableSet : MutableSet<String> = mutableSetOf()
    var preferencesMutableSet : MutableSet<String> = mutableSetOf()
    var cityMutableSet : MutableSet<String> = mutableSetOf()

    public fun instantiateAllBanks(searcher : () -> Unit) {
        instantiateNameBank(searcher)
    }

    private fun instantiateNameBank(searcher : () -> Unit) {

        var getAllSets : (MutableSet<MusicProvider>) -> Unit = {
            nameMutableSet = it.map { it.name }.toMutableSet()
            cityMutableSet = it.map{it.city}.toMutableSet()
            typeMutableSet = it.map{it.musicProviderType}.toMutableSet()
            preferencesMutableSet = it.map{it.musicalPreferences}.toMutableSet()
            println("----------------------------------_________ZBIORY_______------------------------------------")
            nameMutableSet.forEach{println(it)}
            println("----------------------------------------------------------------------")
            typeMutableSet.forEach{println(it)}
            println("----------------------------------------------------------------------")
            preferencesMutableSet.forEach{println(it)}
            println("----------------------------------------------------------------------")
            cityMutableSet.forEach{println(it)}
            println("----------------------------------------------------------------------")
            instantiateRateBank()
            rateMutableSet.forEach{println(it)}
            println("----------------------------------------------------------------------")
            searcher.invoke()
        }
        musicProviderDao.getAllMusicProv(getAllSets)
    }

    private fun instantiateRateBank() {
        rateMutableSet.addAll(mutableSetOf(
            "rate","rated","top rated","best","finest","most","favourable", "leading", "outstanding",
            "perfect", "terrific", "capital", "champion", "prime","foremost","principal","first-class"
        ))
    }



}