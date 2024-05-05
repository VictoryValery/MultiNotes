package com.example.auth.di

import com.example.auth.navigation.AuthNavigation
import com.example.core.di.ComponentHolder

class AuthComponent(
    authDependencies: AuthDependencies,
    val authNavigation: AuthNavigation
) {
    companion object : ComponentHolder<AuthComponent>()

    internal val authVmFactory = AuthVmFactory(
        nameRepository = authDependencies.nameRepository
    )
}