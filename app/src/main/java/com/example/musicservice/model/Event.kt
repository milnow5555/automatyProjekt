package com.example.musicservice.model

import java.time.LocalDate
//Todo sending events to specific music providers
data class Event(
                 var eventName : String = "",
                 var date : String = "",
                 var listOfSignedPrividers : List<MusicProvider> = listOf(),
                 var description : String = "",
                 var ownerId : String = "",
                 var reward : String = "",
                 var eventType : String = "")