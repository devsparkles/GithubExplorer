package com.devsparkle.githubexplorer.data.mapper.response2Domain

import com.devsparkle.githubexplorer.data.remote.response.CommitResponse
import com.devsparkle.githubexplorer.domain.model.CommitDTO
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
        var timeAndDate = ""
        if (c.commitShort.message.isNullOrBlank()) {
            title = c.commitShort.message
        }

        return CommitDTO(
            title = title,
            authorName = authorName,
            authorImage = authorImage,
            timeAndDate = timeAndDate
        )
    }
}