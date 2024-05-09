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

    companion object {
        private const val LOGIN_ERROR = "Имя пользователя должно начинаться с буквы, быть от " +
                "6 до 20 символов и не содержать пробелов"
        private const val PASSWORD_ERROR =
            "Пароль должен содержать буквы и быть от 8 до 25 символов"
    }

    private val _state = MutableStateFlow(AuthState())
    val state = _state.asStateFlow()

    fun onUserNameChange(userName: String) {
        _state.value = _state.value.copy(userName = userName, loginError = null)
    }

    fun onPasswordChange(password: String) {
        _state.value = _state.value.copy(password = password, passwordError = null)
    }

    private fun checkLogin() {
        val userName = state.value.userName ?: ""
        if (userName.isNotBlank() &&
            !userName.contains(" ") &&
            userName.length > 5 &&
            userName.length < 21 &&
            !userName[0].isDigit()
        ) {
            _state.value = _state.value.copy(loginError = null)
        } else {
            _state.value = _state.value.copy(loginError = LOGIN_ERROR)
        }
    }

    private fun checkPassword() {
        val password = state.value.password ?: ""
        if (password.isNotBlank() &&
            !password.contains(" ") &&
            password.length > 7 &&
            password.length < 26 &&
            password.contains(Regex("[a-zA-Z]"))
        ) {
            _state.value = _state.value.copy(passwordError = null)
        } else {
            _state.value = _state.value.copy(passwordError = PASSWORD_ERROR)
        }
    }

    fun loginEnabled(): Boolean {
        val userName = state.value.userName ?: ""
        val password = state.value.password ?: ""
        checkLogin()
        checkPassword()
        return if (state.value.loginError == null && state.value.passwordError == null) {
            nameRepository.setUser(
                UiUser(name = userName, password = password)
            )
            true
        } else {
            false
        }
    }
}