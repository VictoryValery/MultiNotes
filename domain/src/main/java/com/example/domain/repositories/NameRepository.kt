package com.example.domain.repositories

import com.example.common.domain.models.User

interface NameRepository {
    fun getName(): String
    fun setUser(user: User)
}