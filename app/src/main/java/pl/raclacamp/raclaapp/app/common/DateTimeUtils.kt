package pl.raclacamp.raclaapp.app.common

import com.google.firebase.Timestamp
import java.text.SimpleDateFormat
import java.util.Locale

object DateTimeUtils {
    fun formatTimestampToDateString(
        timestamp: Timestamp?,
        format: String = "EEE dd/MM HH:mm"
    ): String {
        val date = timestamp?.toDate()
        val dateFormat = SimpleDateFormat(format, Locale.getDefault())
        return dateFormat.format(date)
    }
}