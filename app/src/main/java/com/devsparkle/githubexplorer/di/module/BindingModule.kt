package com.devsparkle.githubexplorer.di.module

import com.devsparkle.githubexplorer.di.module.scope.PerActivity
import com.devsparkle.githubexplorer.presentation.screen.displayCommits.ListCommitActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BindingModule {

    @PerActivity
    @ContributesAndroidInjector
    abstract fun listCommitActivity(): ListCommitActivity

}