package com.example.quickreply.di

import android.content.Context
import com.example.quickreply.data.database.MessageDatabase
import com.example.quickreply.data.repository.MessageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideDatabase(context: Context): MessageDatabase {
        return MessageDatabase.getDatabase(context)
    }

    @Provides
    @Singleton
    fun provideMessageRepository(database: MessageDatabase): MessageRepository {
        return MessageRepository(database.messageDao())
    }
}