package com.example.data.storage.name

import com.example.common.domain.models.User

interface NameStorage {
    fun getUser(): User
    fun setUser(user: User)
}