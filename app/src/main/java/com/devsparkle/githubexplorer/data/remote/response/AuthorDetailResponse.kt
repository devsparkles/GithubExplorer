package com.devsparkle.githubexplorer.data.remote.response

import com.google.gson.annotations.SerializedName

data class AuthorDetailResponse(
    @SerializedName("avatar_url") var avatarUrl: String
)