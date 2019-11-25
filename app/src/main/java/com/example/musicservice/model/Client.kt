package com.example.musicservice.model

data class Client(val name : String = "",
                  val surname : String = "",
                  val company : String = "",
                  val description : String,
                  val clientEvents : List<Event> = listOf())

