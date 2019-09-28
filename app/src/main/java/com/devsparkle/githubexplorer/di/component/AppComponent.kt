package com.devsparkle.githubexplorer.di.component

import com.devsparkle.githubexplorer.App
import com.devsparkle.githubexplorer.di.module.ApiModule
import com.devsparkle.githubexplorer.di.module.AppModule
import com.devsparkle.githubexplorer.di.module.BindingModule
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [BindingModule::class, AppModule::class, ApiModule::class, AndroidSupportInjectionModule::class])
interface AppComponent {
    fun inject(application: App)
}