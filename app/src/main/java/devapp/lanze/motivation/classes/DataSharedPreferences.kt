package devapp.lanze.motivation.classes

import android.content.Context
import android.content.SharedPreferences

class DataSharedPreferences(context: Context) {

    private val security: SharedPreferences = context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)

    fun storeKey(key: String, str: String) {
        security.edit().putString(key, str).apply()
    }

    fun getString(key: String): String {
       return security.getString(key, "") ?: ""
    }
}