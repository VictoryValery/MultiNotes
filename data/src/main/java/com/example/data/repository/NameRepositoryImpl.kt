package com.example.data.repository

import com.example.common.domain.models.UserName
import com.example.data.storage.name.NameStorage
import com.example.domain.repositories.NameRepository

class NameRepositoryImpl(
    nameStorage: NameStorage
) : NameRepository {
    override fun getName(): UserName {
        TODO("Not yet implemented")
    }

    override fun setName(userName: UserName) {
        TODO("Not yet implemented")
    }
}