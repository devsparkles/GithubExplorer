package com.devsparkle.githubexplorer.data.repository.remote

import com.devsparkle.githubexplorer.data.mapper.response2Domain.CommitResponseToDTOMapper
import com.devsparkle.githubexplorer.data.remote.api.GithubService
import com.devsparkle.githubexplorer.domain.model.CommitDTO
import com.devsparkle.githubexplorer.domain.repository.ICommitRemoteRepository

class CommitRemoteRepository(private var githubService: GithubService,
                             private var mapper: CommitResponseToDTOMapper
): ICommitRemoteRepository {
    override fun getCommits(user: String, repo:String): List<CommitDTO> {
        return githubService.fetchCommits(user, repo)
            .map {
                mapper.toCommitDTO(it)
            }
    }
}