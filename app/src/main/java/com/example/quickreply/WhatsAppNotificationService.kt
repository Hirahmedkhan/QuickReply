package com.example.quickreply

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

class WhatsAppNotificationService : NotificationListenerService() {

    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        if (sbn != null && sbn.packageName == "com.whatsapp") {
            Log.d("WhatsAppService", "Notification from: ${sbn.packageName}")
            val notificationText = sbn.notification.extras.getString("android.text")
            Log.d("WhatsAppMessage" , "Message: $notificationText")
        }
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification?) {
        Log.d("WhatsAppService", "Notification Removed")
    }
}