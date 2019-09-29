package com.devsparkle.githubexplorer.di.module

import com.devsparkle.githubexplorer.di.module.feature.ListCommitActivityModule
import com.devsparkle.githubexplorer.di.module.scope.PerActivity
import com.devsparkle.githubexplorer.presentation.screen.displayCommits.ListCommitActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(ListCommitActivityModule::class))
    abstract fun listCommitActivityModule(): ListCommitActivity


}