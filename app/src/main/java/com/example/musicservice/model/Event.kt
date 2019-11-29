package com.example.musicservice.model

import java.time.LocalDate

data class Event(val date : LocalDate = LocalDate.now(),
                 val providerTypeToSendNotification : MusicProvider.MusicPoviderType = MusicProvider.MusicPoviderType.Musician,
                 val listOfSignedPrividers : List<MusicProvider> = listOf(),
                 val owner : Client,
                 val reward : String = "",
                 val eventType : String = "")