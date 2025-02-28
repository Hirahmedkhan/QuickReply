package com.example.quickreply.utils

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PreferencesHelper @Inject constructor(@ApplicationContext context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

    fun setDatabasePopulated() {
        sharedPreferences.edit().putBoolean("db_populated", true).apply()
    }

    fun isDatabasePopulated(): Boolean {
        return sharedPreferences.getBoolean("db_populated", false)
    }

    fun setMessage(msg: String) {
        sharedPreferences.edit().putString("selected_auto_reply", msg).apply()
    }

    fun getMessage(): String {
        return sharedPreferences.getString("selected_auto_reply", "Hello, Auto Reply Message")
            ?: "Hello, Auto Reply Message"
    }
}