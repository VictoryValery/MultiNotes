package com.example.data.repository

import com.example.common.domain.models.User
import com.example.data.storage.name.NameStorage
import com.example.domain.repositories.NameRepository

class NameRepositoryImpl(
    private val nameStorage: NameStorage
) : NameRepository {
    override fun getName(): String {
        return nameStorage.getUser().name
    }

    override fun setUser(user: User) {
        nameStorage.setUser(user)
    }
}