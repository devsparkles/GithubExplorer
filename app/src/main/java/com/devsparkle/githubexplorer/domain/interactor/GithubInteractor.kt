package com.devsparkle.githubexplorer.domain.interactor

import com.devsparkle.githubexplorer.data.repository.remote.CommitRemoteRepository
import com.devsparkle.githubexplorer.domain.model.CommitDTO
import com.devsparkle.githubexplorer.domain.repository.ICommitRemoteRepository
import io.reactivex.Single
import javax.inject.Inject

open class GithubInteractor @Inject constructor(val commitRemoteRepository: ICommitRemoteRepository) {


    fun getCommitsByUserAndRepo(user: String, repo:String): Single<List<CommitDTO>> {
        return commitRemoteRepository.fetchCommits(user, repo)
    }


}