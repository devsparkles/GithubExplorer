package com.devsparkle.githubexplorer.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CommitDTO(
    var title: String,
    var authorImage: String,
    var authorName: String,
    var timeAndDate: String,
    var authorEmail: String
) : Parcelable