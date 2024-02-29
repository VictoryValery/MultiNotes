package com.example.auth.di

import com.example.domain.repositories.NameRepository

interface AuthDependencies {
    val nameRepository: NameRepository

    companion object {
        fun init(
            nameRepository: NameRepository
        ): AuthDependencies = AuthDependenciesImpl(
            nameRepository = nameRepository
        )
    }
}

private class AuthDependenciesImpl(
    override val nameRepository: NameRepository
) : AuthDependencies