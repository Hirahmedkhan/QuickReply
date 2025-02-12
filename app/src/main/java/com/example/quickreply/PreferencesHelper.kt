package com.example.quickreply

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PreferencesHelper @Inject constructor(@ApplicationContext context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

    fun isDatabasePopulated(): Boolean {
        return sharedPreferences.getBoolean("db_populated", false)
    }

    fun setDatabasePopulated() {
        sharedPreferences.edit().putBoolean("db_populated", true).apply()
    }
}
