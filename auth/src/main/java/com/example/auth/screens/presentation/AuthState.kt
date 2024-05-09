package com.example.auth.screens.presentation

import androidx.compose.runtime.Immutable

@Immutable
internal data class AuthState(
    val userName: String? = null,
    val password: String? = null,
    val loginError: String? = null,
    val passwordError: String? = null,
)
