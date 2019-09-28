package com.devsparkle.githubexplorer.di.module

import com.devsparkle.githubexplorer.data.remote.api.GithubService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiModule {


    @Singleton
    @Provides
    fun provideRetrofit(
        retrofitBuilder: Retrofit.Builder
        //, okHttpClientBuilder: OkHttpClient.Builder
    ): Retrofit {
        return retrofitBuilder
          //  .client(okHttpClientBuilder.build())
            .baseUrl("https://api.github.com/")
            .build()
    }

    @Singleton
    @Provides
    fun provideGithubService(retrofit: Retrofit): GithubService {
        return retrofit.create(GithubService::class.java)
    }
}