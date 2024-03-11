package com.example.odev7.di

import android.content.Context
import androidx.room.Room
import com.example.odev7.data.datasource.YapilacaklarDataSource
import com.example.odev7.data.repo.YapilacaklarRepository
import com.example.odev7.room.Veritabani
import com.example.odev7.room.YapilacaklarDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideYapilacaklarRepository(yds: YapilacaklarDataSource) : YapilacaklarRepository{
        return YapilacaklarRepository(yds)
    }

    @Provides
    @Singleton
    fun provideYapilacaklarDataSource(ydao:YapilacaklarDao) : YapilacaklarDataSource {
        return YapilacaklarDataSource(ydao)
    }

    @Provides
    @Singleton
    fun provideKisilerDao(@ApplicationContext context: Context) : YapilacaklarDao {
        val vt = Room.databaseBuilder(context, Veritabani::class.java,"toDos.sqlite")
            .createFromAsset("toDos.sqlite").build()
        return vt.getYapilacaklarDao()
    }
}