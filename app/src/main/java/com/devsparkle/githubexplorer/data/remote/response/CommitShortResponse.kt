package com.devsparkle.githubexplorer.data.remote.response

import com.google.gson.annotations.SerializedName

data class CommitShortResponse(
    @SerializedName("message") var message: String,
    @SerializedName("author") var authorShort: AuthorShortResponse
)
