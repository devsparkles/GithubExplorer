package com.devsparkle.githubexplorer.data.mapper.response2Domain

import com.devsparkle.githubexplorer.data.remote.response.CommitResponse
import com.devsparkle.githubexplorer.domain.model.CommitDTO
import com.devsparkle.githubexplorer.shared.utils.FormatUtils
import com.google.gson.Gson
import javax.inject.Inject

open class CommitResponseToDTOMapper @Inject constructor(val gson: Gson) {

    fun toCommitDTOList(list: List<CommitResponse>): List<CommitDTO> {
        val result: MutableList<CommitDTO> = mutableListOf()

        for (cr: CommitResponse in list) {
            result.add(toCommitDTO(cr))
        }

        return result
    }


    fun toCommitDTO(c: CommitResponse): CommitDTO {
        var title = ""
        var authorName = ""
        var authorImage = ""
        var authorEmail = ""
        var timeAndDate = ""

        title = c.commitShort.message
        authorName = c.commitShort.authorShort.name
        c.authorDetail?.let {
            authorImage = it.avatarUrl
        }

        authorEmail = c.commitShort.authorShort.email
        timeAndDate = FormatUtils.toISO8601UTC(c.commitShort.authorShort.date)

        return CommitDTO(
            title = title,
            authorName = authorName,
            authorImage = authorImage,
            authorEmail = authorEmail,
            timeAndDate = timeAndDate
        )
    }
}