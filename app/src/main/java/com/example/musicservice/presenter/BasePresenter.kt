package com.example.musicservice.presenter

interface BasePresenter<V> {
    fun setView(view : V)
}