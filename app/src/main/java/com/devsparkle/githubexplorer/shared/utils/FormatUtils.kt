package com.devsparkle.githubexplorer.shared.utils

import java.text.SimpleDateFormat
import java.util.*


// singleton in kotlin that class should not need to be instanciated more than once
object FormatUtils {


    // SOLID Principle do not do formating in the mapper or somewhere else . Single responsability
    // Benefit. Cleaner code. Testability improved
    // another possibility is to use the kotlin extensions
    fun toISO8601UTC(date: Date): String {
        val tz = TimeZone.getTimeZone("UTC")
        val df = SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'", Locale.UK)
        df.timeZone = tz
        return df.format(date)
    }


}