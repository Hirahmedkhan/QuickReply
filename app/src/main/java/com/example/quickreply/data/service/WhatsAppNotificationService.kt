package com.example.quickreply.data.service

import android.app.Notification
import android.app.PendingIntent
import android.app.RemoteInput
import android.content.Intent
import android.os.Bundle
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

class WhatsAppNotificationService : NotificationListenerService() {

    private val lastMessageTimestamps = mutableMapOf<String, Long>()
    private val REPLY_DELAY_MS = 5000L

    override fun onNotificationPosted(sbn: StatusBarNotification?) {

        if (sbn != null && sbn.packageName == "com.whatsapp") {
            val extras = sbn.notification.extras
            val message = extras.getString("android.text") ?: return
            val senderName = extras.getString("android.title") ?: return

            Log.d("WhatsAppService", "onNotificationPosted: $message")
            Log.d("WhatsAppService", "onNotificationPosted: $senderName")

            val currentTime = System.currentTimeMillis()
            val lastReplyTime = lastMessageTimestamps[senderName] ?: 0L

            if (currentTime - lastReplyTime < REPLY_DELAY_MS) {
                Log.d("WhatsAppService", "AutoReply skipped for $senderName due to delay")
                return
            }

            Log.d("WhatsAppService", "New WhatsApp message detected")
            lastMessageTimestamps[senderName] = currentTime

            sendReplyToNotification(sbn, "Hello, Auto Reply Message")
        }
    }

    private fun sendReplyToNotification(sbn: StatusBarNotification, replyText: String) {
        val actions = sbn.notification.actions
        actions?.forEach { action ->
            if (action?.title?.toString()?.contains("Reply", true) == true) {
                sendReply(action, replyText)
            }
        }
    }

    private fun sendReply(action: Notification.Action, replyText: String) {
        val bundle = Bundle()
        bundle.putCharSequence(action.remoteInputs[0].resultKey, replyText)

        val intent = Intent()
        RemoteInput.addResultsToIntent(action.remoteInputs, intent, bundle)

        try {
            action.actionIntent.send(this, 0, intent)
        } catch (e: PendingIntent.CanceledException) {
            Log.e("WhatsappService", "Failed to send reply: ${e.message}")
        }
    }
}
