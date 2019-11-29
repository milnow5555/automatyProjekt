package com.example.musicservice.model

data class MusicProvider(val name : String = "",
                         val active : Boolean = true,
                         val city : String = "",
                         val description : String = "",
                         val rating : Double = 0.0,
                         val musicProvidersApproachingEvents : List<Event> = listOf(),
                         val musicProviderType : MusicPoviderType = MusicPoviderType.Musician,
                         val musicalPreferences: MusicProviderMusicalPreferences = MusicProviderMusicalPreferences.Jazz) {


    enum class MusicPoviderType {
        Orchestra, Band, BigBand, Musician, Composer, Producer
    }
    enum class MusicProviderMusicalPreferences {
        Jazz, Metal, ClassicalMusic, HardRock, HipHop, Regge
    }
}