package com.devsparkle.githubexplorer.domain.repository

import com.devsparkle.githubexplorer.domain.model.CommitDTO

interface ICommitRemoteRepository {
    fun getCommits(user: String, repo:String): List<CommitDTO>

}