package com.example.musicservice.mvpcontract.client

import com.example.musicservice.model.Event


interface ClientPersonalEventListContract {
    interface ClientPersonalEventListView {
        fun initializeRecyclerView(clietnsEventList : MutableList<Event?>)
        fun hideProgressBar()
        fun showProgressBar()
    }
    interface ClientPersonalEventListPresenter {
        fun getAllPersonalEvents()
    }
}