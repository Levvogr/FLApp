package com.levog.flapp.notification

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.levog.flapp.MainActivity
import com.levog.flapp.R
import com.levog.flapp.data.room.medicalexamination.MedicalExaminationData

class FLNotificationService(
    private val context: Context
) {

    private val notificationManager =
        context
            .getSystemService(Context.NOTIFICATION_SERVICE) as
                NotificationManager

    @SuppressLint("ScheduleExactAlarm")
    fun showNotification(medicalExamination: MedicalExaminationData) {
        val activityIntent = Intent(context, MainActivity::class.java)
        val activityPendingIntent = PendingIntent.getActivity(
            context,
            1,
            activityIntent,
            PendingIntent.FLAG_IMMUTABLE
        )

        val alarmService = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val time = medicalExamination.dateExamination

        alarmService.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            time,
            activityPendingIntent
        )
        val notification = NotificationCompat.Builder(context, FL_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Напоминание о медосмотре")
            .setContentIntent(activityPendingIntent)
            .build()

        notificationManager.notify(1, notification)

    }


    companion object {
        const val FL_CHANNEL_ID = "fl_channel"
    }
}