package com.example.common.domain.models

import com.example.common_ui.domain.ui_models.UiUser

data class User(
    val name: String,
    val password: String
)

fun User.toUiUser(): UiUser {
    return UiUser(
        name = name,
        password = password
    )
}

fun UiUser.toUser(): User {
    return User(
        name = name,
        password = password
    )
}