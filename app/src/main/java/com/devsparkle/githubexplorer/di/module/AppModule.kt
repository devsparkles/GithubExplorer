package com.devsparkle.githubexplorer.di.module

import android.app.Application
import android.content.Context
import com.devsparkle.githubexplorer.data.mapper.response2Domain.CommitResponseToDTOMapper
import com.devsparkle.githubexplorer.data.remote.api.GithubService
import com.devsparkle.githubexplorer.data.repository.remote.CommitRemoteRepository
import com.devsparkle.githubexplorer.domain.repository.ICommitRemoteRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    internal fun provideCommitRemoteRepository(githubService: GithubService,
                                               mapper: CommitResponseToDTOMapper
    ): ICommitRemoteRepository =
        CommitRemoteRepository(githubService, mapper)
}