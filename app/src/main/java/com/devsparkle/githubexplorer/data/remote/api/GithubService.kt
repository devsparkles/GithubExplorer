package com.devsparkle.githubexplorer.data.remote

import com.devsparkle.githubexplorer.data.remote.response.CommitResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface GithubService {

    @GET
    fun fetchCommits(
        @Url url: String
    ): List<CommitResponse>

}