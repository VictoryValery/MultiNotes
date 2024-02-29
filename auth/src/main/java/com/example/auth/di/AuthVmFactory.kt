package com.example.auth.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.auth.screens.AuthViewModel
import com.example.domain.repositories.NameRepository

class AuthVmFactory(
    private val nameRepository: NameRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AuthViewModel(nameRepository) as T
    }
}