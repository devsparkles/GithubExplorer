package com.devsparkle.githubexplorer.di.module.feature

import com.devsparkle.githubexplorer.domain.interactor.GithubInteractor
import com.devsparkle.githubexplorer.presentation.screen.displayCommits.ListCommitActivity
import com.devsparkle.githubexplorer.presentation.screen.displayCommits.ListCommitPresenter
import dagger.Module
import dagger.Provides

@Module
class ListCommitActivityModule {
    @Provides
    fun provideListCommitPresenter(activity: ListCommitActivity,
                           githubInteractor: GithubInteractor
    ): ListCommitPresenter = ListCommitPresenter(activity, githubInteractor)
}