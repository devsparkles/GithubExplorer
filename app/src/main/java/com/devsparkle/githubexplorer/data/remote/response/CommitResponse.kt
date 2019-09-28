package com.devsparkle.githubexplorer.data.remote.response

import com.google.gson.annotations.SerializedName
import java.util.*

data class CommitResponse(
    @SerializedName("author") var authorDetail: AuthorDetailResponse,
    @SerializedName("commit") var commitShort: CommitShortResponse
)