package com.example.domain.repositories

import com.example.common.domain.models.UserName

interface NameRepository {
    fun getName(): UserName
    fun setName(userName: UserName)
}