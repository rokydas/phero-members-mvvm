package com.example.pherofamily.di

import android.app.Application
import com.example.pherofamily.data.remote.PheroApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providePheroApi(): PheroApi {
        return Retrofit.Builder()
            .baseUrl("https://hq.programming-hero.com/api/v1/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(PheroApi::class.java)
    }
}