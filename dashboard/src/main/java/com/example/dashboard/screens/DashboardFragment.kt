package com.example.dashboard.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.dashboard.di.DashboardComponent

class DashboardFragment() : Fragment() {

    private val viewModel: DashboardViewModel by viewModels {
        DashboardComponent.get().dashboardVmFactory
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
            DashboardScreen(
                state = state,
                onDelete = viewModel::deleteNote
            )
        }
    }
}
