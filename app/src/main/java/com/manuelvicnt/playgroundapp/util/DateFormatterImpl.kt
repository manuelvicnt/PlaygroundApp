package com.manuelvicnt.playgroundapp.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

class DateFormatterImpl : DateFormatter {

    @SuppressLint("SimpleDateFormat")
    private val formatter = SimpleDateFormat("d MMM yyyy HH:mm:ss")

    override fun formatDate(timestamp: Long): String {
        return formatter.format(Date(timestamp))
    }
}
