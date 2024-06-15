package com.levog.flapp.extension

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.Locale

fun Long.toFormattedDateString(): String {
    val sdf = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
    return sdf.format(this)
}
fun Long.toFormattedTimeString(): String {
    val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
    val temp = sdf.format(this)
    var hours = temp.substring(0,2).toInt()-3
    if(hours<0){
        hours += 24
    }
    return hours.toString()+temp.substring(2)
}
fun Long.toFormattedTimeStringOnlyWeek(): String {
    val sdf = SimpleDateFormat("EE", Locale.getDefault())
    return sdf.format(this)
}
fun LocalTime.toFormattedTimeString(): String {
    return DateTimeFormatter
        .ofPattern("HH:mm")
        .format(this)
}
fun LocalDate.toLong(): Long {
    return this.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli()
}
fun LocalDateTime.toLong(): Long {
    return this.atZone(ZoneOffset.UTC).toInstant().toEpochMilli()
}
fun LocalDate.toFormattedDateString(): String {
    return DateTimeFormatter
        .ofPattern("dd.MM.yyyy")
        .format(this)
}
fun LocalDate.toFormattedDateStringFull(): String {
    return DateTimeFormatter
        .ofLocalizedDate(FormatStyle.FULL)
        .format(LocalDate.of(this.year, this.month, this.dayOfMonth))
}
fun Long.toFormattedDateStringFull(): String {
    val temp = this.toFormattedTimeString()
    return DateTimeFormatter
        .ofLocalizedDate(FormatStyle.FULL)
        .format(LocalDate.of(
            temp.substring(6).toInt(),
            temp.substring(3,5).toInt(),
            temp.substring(0,2).toInt())
        )
}