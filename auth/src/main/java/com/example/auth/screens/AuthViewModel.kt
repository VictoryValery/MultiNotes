package com.example.auth.screens

import androidx.lifecycle.ViewModel
import com.example.auth.screens.presentation.AuthState
import com.example.common_ui.domain.ui_models.UiUser
import com.example.domain.repositories.NameRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

internal class AuthViewModel(
    private val nameRepository: NameRepository
) : ViewModel() {
    private val _state = MutableStateFlow(AuthState())
    val state = _state.asStateFlow()

    fun onUserNameChange(userName: String) {
        _state.value = _state.value.copy(userName = userName)
    }

    fun onPasswordChange(password: String) {
        _state.value = _state.value.copy(password = password)
    }

    fun onLoginClick() {
        val userName = state.value.userName ?: ""
        val password = state.value.password ?: ""

        if (userName.isNotBlank() && password.isNotBlank() &&
            !userName.contains(" ") &&
            !password.contains(" ")
        ) {
            nameRepository.setUser(
                UiUser(name = userName, password = password)
            )
        }
    }
}