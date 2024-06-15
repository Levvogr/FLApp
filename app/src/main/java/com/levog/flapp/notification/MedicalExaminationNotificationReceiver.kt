package com.levog.flapp.notification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MedicalExaminationNotificationReceiver : BroadcastReceiver(){
    override fun onReceive(context: Context, intent: Intent?) {
        val service = FLNotificationService(context)
/*
        service.showNotification(conte)

        CoroutineScope(Dispatchers.IO).launch {
            counterDataStoreManager.saveCounterValue(GlobalCounter.counter)
        }
        //counterViewModel.addToCounterValue(1, counterDataStoreManager)

        service.showNotification(GlobalCounter.counter)*/
    }
}