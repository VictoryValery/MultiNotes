package com.example.data.repository

import com.example.common.domain.models.toUser
import com.example.common_ui.domain.ui_models.UiUser
import com.example.data.storage.name.NameStorage
import com.example.domain.repositories.NameRepository

class NameRepositoryImpl(
    private val nameStorage: NameStorage
) : NameRepository {
    override fun getName(): String {
        return nameStorage.getUser().name
    }

    override fun setUser(user: UiUser) {
        nameStorage.setUser(user.toUser())
    }
}