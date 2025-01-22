package com.example.quickreply.domain

import android.accessibilityservice.AccessibilityService
import android.content.Intent
import android.util.Log
import android.view.accessibility.AccessibilityEvent

class WhatsAppReplyService : AccessibilityService() {

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        if (event?.packageName == "com.whatsapp") {
            val message = event.text?.toString()
            if (message?.contains("Hello") == true) {
                Log.d("CheckMessage" ,"$message")

                sendReply("Hi! How can i help you?")
                Log.d("CheckReply" ,"$message")
            }
        }
    }

    override fun onInterrupt() {
        TODO("Not yet implemented")
    }

    private fun sendReply(reply: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.setPackage("com.whatsapp")
        intent.putExtra(Intent.EXTRA_TEXT, reply)
        startActivity(intent)
    }
}