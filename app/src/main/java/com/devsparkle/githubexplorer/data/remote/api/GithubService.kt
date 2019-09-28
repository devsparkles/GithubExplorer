package com.devsparkle.githubexplorer.data.remote.api

import com.devsparkle.githubexplorer.data.remote.response.CommitResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    @GET("repos/{user}/{repo}/commits")
    fun fetchCommits(@Path("user") user: String, @Path("repo") repo: String): List<CommitResponse>


}