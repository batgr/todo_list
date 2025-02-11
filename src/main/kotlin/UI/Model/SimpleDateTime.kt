package UI.Model

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class SimpleDateTime(private val dateTime: LocalDateTime) {

    fun getDateAsText():String{
        val date = dateTime.toLocalDate()
        val time = dateTime.toLocalTime()
        return formatDateTime(date, time)
    }

    private fun formatDateTime(date: LocalDate, time: LocalTime): String {
        val now = LocalDate.now()
        val yesterday = now.minusDays(1)

        return when (date) {
            now -> "Today, ${formatTime(time)}"
            yesterday -> "Yesterday, ${formatTime(time)}"
            else -> "${formatDate(date)}, ${formatTime(time)}"
        }
    }

    private fun formatTime(time:LocalTime):String{
        val formater = DateTimeFormatter.ofPattern("HH:mm a")
        return time.format(formater)
    }

    private fun formatDate(date:LocalDate):String{
        val formater = DateTimeFormatter.ofPattern("dd/MM/yyyy")

        return date.format(formater)
    }

}