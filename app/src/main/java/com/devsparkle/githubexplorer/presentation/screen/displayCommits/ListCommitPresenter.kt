package com.devsparkle.githubexplorer.presentation.screen.displayCommits

import com.devsparkle.githubexplorer.domain.interactor.GithubInteractor
import com.devsparkle.githubexplorer.presentation.screen.base.BasePresenter
import javax.inject.Inject

class ListCommitPresenter @Inject constructor(
    val view: ListCommitActivity,
    var githubInteractor: GithubInteractor
) :
    BasePresenter<ListCommitContract.View>(),
    ListCommitContract.Presenter {


    override fun getCommitList(user: String, repo: String) {
        fetch(githubInteractor.getCommitsByUserAndRepo(user, repo),
            {
                view.showCommitList(it)
            },
            {
                it.message?.let {
                    view.showError(it)
                }
            })
    }

}