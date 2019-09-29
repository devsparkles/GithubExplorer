package com.devsparkle.githubexplorer.data.repository.remote

import androidx.lifecycle.Transformations.map
import com.devsparkle.githubexplorer.data.mapper.response2Domain.CommitResponseToDTOMapper
import com.devsparkle.githubexplorer.data.remote.api.GithubService
import com.devsparkle.githubexplorer.data.remote.response.CommitResponse
import com.devsparkle.githubexplorer.domain.model.CommitDTO
import com.devsparkle.githubexplorer.domain.repository.ICommitRemoteRepository
import io.reactivex.Single
import retrofit2.Response

class CommitRemoteRepository(private var githubService: GithubService,
                             private var mapper: CommitResponseToDTOMapper
): ICommitRemoteRepository {
    override fun getCommits(user: String, repo:String): Single<List<CommitDTO>> {
        return githubService.fetchCommits(user, repo)
            .map {
                if(it.isNullOrEmpty()){
                    emptyList<CommitDTO>()
                } else {
                    mapper.toCommitDTOList(it)
                }
            }

    }
}