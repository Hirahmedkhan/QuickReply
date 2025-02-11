package com.example.quickreply.di

import android.content.Context
import androidx.room.Room
import com.example.quickreply.data.database.MessageDao
import com.example.quickreply.data.database.MessageDatabase
import com.example.quickreply.data.repository.MessageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): MessageDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            MessageDatabase::class.java,
            "message_database"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideMessageDao(database: MessageDatabase): MessageDao {
        return database.messageDao()
    }
}
