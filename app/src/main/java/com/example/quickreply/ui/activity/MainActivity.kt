package com.example.quickreply.ui.activity

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.quickreply.R
import com.example.quickreply.domain.WhatsAppReplyService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        if (!isNotificationServiceEnabled()) {
            Toast.makeText(this, "Please enable notification access", Toast.LENGTH_SHORT).show()
            startActivity(Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS))
            triggerWhatsAppReplyService()

        }else{
            Toast.makeText(this, "Enabled", Toast.LENGTH_SHORT).show()        }
    }

    private fun isNotificationServiceEnabled(): Boolean {
        val contentResolver = applicationContext.contentResolver
        val enabledNotificationListeners =
            Settings.Secure.getString(contentResolver, "enabled_notification_listener")
        return enabledNotificationListeners?.contains(packageName) == true
    }

    private fun triggerWhatsAppReplyService(){
        val intent = Intent(this, WhatsAppReplyService::class.java)
        startService(intent)
    }
}