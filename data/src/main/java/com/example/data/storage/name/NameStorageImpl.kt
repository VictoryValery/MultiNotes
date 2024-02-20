package com.example.data.storage.name

import android.content.Context
import com.example.common.domain.models.UserName

class NameStorageImpl(context: Context) : NameStorage {

    companion object {
        private const val SHARED_PREFS_ID = "SHARED_PREFS_ID"
        private const val KEY_NAME = "KEY_NAME"
        private const val EMPTY_NAME = ""
    }

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_ID, Context.MODE_PRIVATE)

    override fun getName(): UserName {
        return UserName(name = sharedPreferences.getString(KEY_NAME, EMPTY_NAME) ?: EMPTY_NAME)
    }

    override fun setName(userName: UserName) {
        sharedPreferences.edit().putString(KEY_NAME, userName.name).apply()
    }
}