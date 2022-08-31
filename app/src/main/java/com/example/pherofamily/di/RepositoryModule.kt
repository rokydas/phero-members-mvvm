package com.example.pherofamily.di
import com.example.pherofamily.data.repository.PheroRepositoryImpl
import com.example.pherofamily.repository.PheroRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun pheroRepository(
        pheroRepositoryImpl: PheroRepositoryImpl
    ): PheroRepository
}