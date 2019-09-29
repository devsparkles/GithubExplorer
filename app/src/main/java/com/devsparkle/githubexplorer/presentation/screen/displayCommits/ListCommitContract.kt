package com.devsparkle.githubexplorer.presentation.screen.displayCommits

import com.devsparkle.githubexplorer.domain.model.CommitDTO
import com.devsparkle.githubexplorer.presentation.screen.base.BaseContract

interface ListCommitContract{
    interface View : BaseContract.View {
        fun showCommitList(list: List<CommitDTO>)
    }


    interface Presenter : BaseContract.Presenter<View> {
        fun getCommitList(user:String, repo:String)

    }
}