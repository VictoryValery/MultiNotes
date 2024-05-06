package com.example.domain.repositories

import com.example.common_ui.domain.ui_models.UiUser

interface NameRepository {
    fun getName(): String
    fun setUser(user: UiUser)
}