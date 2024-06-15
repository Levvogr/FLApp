package com.levog.flapp

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import com.levog.flapp.data.room.ApplicationContainer
import com.levog.flapp.data.room.ApplicationDataContainer
import com.levog.flapp.notification.FLNotificationService

class FLApplication : Application(){
    lateinit var container: ApplicationContainer
    override fun onCreate() {
        super.onCreate()
        container = ApplicationDataContainer(this)
    }
    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            FLNotificationService.FL_CHANNEL_ID,
            "Counter",
            NotificationManager.IMPORTANCE_DEFAULT
        )
        channel.description = "Used for the increment counter notifications"

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}