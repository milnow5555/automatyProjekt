package com.example.musicservice.model

data class MusicProvider(var id : String? = "",
                         val name : String = "",
                         val active : Boolean = true,
                         val city : String = "",
                         val description : String = "",
                         val rating : Double = 0.0,
                         val musicProvidersApproachingEvents : List<Event> = listOf(),
                         val musicProvidersInvitations : List<Event> = listOf(),
                         val musicProviderType : String = "",
                         val musicalPreferences: String  = "") {


    enum class MusicPoviderType {
        Orchestra,Jazz_Band, BigBand, Musician, Composer, Producer
    }
    enum class MusicProviderMusicalPreferences {
        Jazz, Metal, ClassicalMusic, HardRock, HipHop, Regge
    }
}