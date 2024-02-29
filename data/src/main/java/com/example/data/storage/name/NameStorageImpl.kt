package com.example.data.storage.name

import android.content.Context
import com.example.common.domain.models.User

class NameStorageImpl(context: Context) : NameStorage {

    companion object {
        private const val SHARED_PREFS_ID = "SHARED_PREFS_ID"
        private const val KEY_NAME = "KEY_NAME"
        private const val KEY_PASS = "KEY_PASS"
        private const val EMPTY = ""
    }

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_ID, Context.MODE_PRIVATE)

    override fun getUser(): User {
        return User(
            name = sharedPreferences.getString(KEY_NAME, EMPTY) ?: EMPTY,
            password = sharedPreferences.getString(KEY_PASS, EMPTY) ?: EMPTY,
        )
    }

    override fun setUser(user: User) {
        sharedPreferences.edit().putString(KEY_NAME, user.name).apply()
        sharedPreferences.edit().putString(KEY_PASS, user.password).apply()
    }
}