package com.example.data.storage.name

import com.example.common.domain.models.UserName

interface NameStorage {
    fun getName(): UserName
    fun setName(userName: UserName)
}