package com.example.todo.domain.time

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime

object DateTimeUtil {
    fun now() : LocalDateTime{
        return Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
    }
    fun toEpochMillis(dateTime: LocalDateTime) : Long{
        return dateTime.toInstant(TimeZone.currentSystemDefault()).toEpochMilliseconds()
    }
    fun formatDateTime(dateTime: LocalDateTime) : String{
        val month = dateTime.month.name.lowercase().replaceFirstChar { it.uppercase() }
        val day = if(dateTime.dayOfMonth < 10) "0${dateTime.dayOfMonth}" else dateTime.dayOfMonth
        val year = dateTime.year
        val hour = if(dateTime.hour < 10) "0${dateTime.hour}" else dateTime.hour
        val minute = if(dateTime.minute < 10) "0${dateTime.minute}" else dateTime.minute
        val second = if(dateTime.second < 10) "0${dateTime.second}" else dateTime.second

        return buildString {
            append(month)
            append(" ")
            append(day)
            append(" ")
            append(year)
            append(", ")
            append(hour)
            append(":")
            append(minute)
        }
    }
}