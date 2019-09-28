package com.devsparkle.githubexplorer.domain.interactor

import com.devsparkle.githubexplorer.data.repository.remote.CommitRemoteRepository
import com.devsparkle.githubexplorer.domain.model.CommitDTO
import com.devsparkle.githubexplorer.domain.repository.ICommitRemoteRepository
import javax.inject.Inject

class GithubInteractor @Inject constructor(val commitRemoteRepository: ICommitRemoteRepository) {


    fun getJetBrainsKotlinCommits(): List<CommitDTO> {
        return commitRemoteRepository.getCommits("Jetbrains", "kotlin")
    }


}