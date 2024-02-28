package com.example.data.repository

import com.example.common.domain.models.UserName
import com.example.data.storage.name.NameStorage
import com.example.domain.repositories.NameRepository

class NameRepositoryImpl(
    private val nameStorage: NameStorage
) : NameRepository {
    override fun getName(): UserName {
        return nameStorage.getName()
    }

    override fun setName(userName: UserName) {
        nameStorage.setName(userName)
    }
}