package com.example.auth.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.auth.di.AuthComponent

class AuthFragment : Fragment() {

    private val navigation = AuthComponent.get().authNavigation
    private val viewModel: AuthViewModel by viewModels {
        AuthComponent.get().authVmFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (view as ComposeView).setContent {
            val state by viewModel.state.collectAsState()
            AuthScreen(
                state = state,
                onUserNameChange = { name -> viewModel.onUserNameChange(name) },
                onPasswordChange = { password -> viewModel.onPasswordChange(password) },
                onLoginClick = {
                    if (viewModel.loginEnabled()) {
                        navigation.dashboard(this)
                    }
                }
            )
        }
    }
}