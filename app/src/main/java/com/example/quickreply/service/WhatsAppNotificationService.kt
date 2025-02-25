package com.example.quickreply.service

import android.app.Notification
import android.app.PendingIntent
import android.app.RemoteInput
import android.content.Intent
import android.os.Bundle
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

class WhatsAppNotificationService : NotificationListenerService() {

    companion object {
        private const val WHATSAPP = "com.whatsapp"
    }

    private val lastMessageTimestamps = mutableMapOf<String, Long>()
    private val messageDelayTime = 5000L

    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        if (sbn == null) return
        if (sbn.packageName != WHATSAPP) return

        val extras = sbn.notification.extras
        val message = extras.getString("android.text") ?: return
        val senderName = extras.getString("android.title") ?: return

        Log.d("WhatsAppService", "message: $message")
        Log.d("WhatsAppService", "Sender Name: $senderName")

        if (senderName == "You") {
            Log.d("WhatsAppService", "Skipping auto-reply for self message.")
            return
        }

        val currentTime = System.currentTimeMillis()
        val lastReplyTime = lastMessageTimestamps[senderName] ?: 0L

        if (currentTime - lastReplyTime < messageDelayTime) {
            Log.d("WhatsAppService", "AutoReply skipped for $senderName due to delay")
            return
        }

        Log.d("WhatsAppService", "New WhatsApp message detected")
        lastMessageTimestamps[senderName] = currentTime

        sendReplyToNotification(sbn, "Hello, Auto Reply Message")
    }

    private fun sendReplyToNotification(sbn: StatusBarNotification, replyText: String) {
        val sharedPreferences = getSharedPreferences("AutoReplyPrefs", MODE_PRIVATE)
        val replyMessage = sharedPreferences.getString("selected_auto_reply", "Hello, Auto Reply Message") ?: "Hello, Auto Reply Message"


        val actions = sbn.notification.actions
        actions?.forEach {action ->
            if (action?.title?.toString()?.contains("Reply", true) == true) {
                sendReply(action, replyMessage)
            }
        }
    }

    private fun sendReply(action: Notification.Action, replyText: String) {
        val bundle = Bundle()
        bundle.putCharSequence(action.remoteInputs[0].resultKey, replyText)

        val intent = Intent()
        RemoteInput.addResultsToIntent(action.remoteInputs, intent, bundle)

        try {
            action.actionIntent.send(this, PendingIntent.FLAG_UPDATE_CURRENT, intent)

        } catch (e: PendingIntent.CanceledException) {
            Log.e("WhatsappService", "Failed to send reply: ${e.message}")
        }
    }
}
