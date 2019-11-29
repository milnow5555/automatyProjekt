package com.example.musicservice.firebase.dao.event

import com.example.musicservice.model.Event
import com.google.firebase.database.DatabaseReference

class EventDaoImpl : EventDao {
    override fun getAll(): List<Event> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getByCurrentUserId(): DatabaseReference {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getByName(name: String): Event {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun save(t: Event) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}