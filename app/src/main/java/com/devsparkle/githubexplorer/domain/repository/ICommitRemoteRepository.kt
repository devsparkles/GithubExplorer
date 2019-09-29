package com.devsparkle.githubexplorer.domain.repository

import com.devsparkle.githubexplorer.domain.model.CommitDTO
import io.reactivex.Single

interface ICommitRemoteRepository {
    fun fetchCommits(user: String, repo:String): Single<List<CommitDTO>>

}