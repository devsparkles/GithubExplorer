package com.devsparkle.githubexplorer.data.remote.response

import com.google.gson.annotations.SerializedName
import java.util.*

data class AuthorShortResponse(
    @SerializedName("name") var name: String,
    @SerializedName("email") var email: String,
    @SerializedName("date") var date: Date
)