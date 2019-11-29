package com.example.musicservice.di.modules

import com.example.musicservice.di.modules.FirebaseModule
import com.example.musicservice.firebase.auth.FirebaseAuthManager
import com.example.musicservice.firebase.auth.FirebaseAuthManagerImpl
import com.example.musicservice.firebase.dao.client.ClientDao
import com.example.musicservice.firebase.dao.client.ClientDaoImpl
import com.example.musicservice.firebase.dao.musicprovider.MusicProviderDao
import com.example.musicservice.firebase.dao.musicprovider.MusicProviderDaoImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [FirebaseModule::class])
@Singleton
abstract class InteractionModule {

    @Binds
    abstract fun authentication(authentication: FirebaseAuthManagerImpl): FirebaseAuthManager

    @Binds
    abstract fun clientDao(database: ClientDaoImpl): ClientDao

    @Binds
    abstract fun musicProviderDao(database: MusicProviderDaoImpl): MusicProviderDao

}