package com.example.musicservice.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
@Singleton
class AppModule(private val app: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context = app
}