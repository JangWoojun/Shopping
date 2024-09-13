package com.seogaemo.di

import com.seogaemo.data.repository.MainRepositoryImpl
import com.seogaemo.data.repository.TempRepositoryImpl
import com.seogaemo.domain.repository.MainRepository
import com.seogaemo.domain.repository.TempRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    @Singleton
    fun bindTempRepository(tempRepositoryImpl: TempRepositoryImpl): TempRepository

    @Binds
    @Singleton
    fun bindMainRepository(mainRepositoryImpl: MainRepositoryImpl): MainRepository
}