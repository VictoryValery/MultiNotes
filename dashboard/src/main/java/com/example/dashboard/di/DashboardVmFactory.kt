package com.example.dashboard.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dashboard.domain.DashboardRepository
import com.example.dashboard.screens.DashboardViewModel

class DashboardVmFactory(
    private val repository: DashboardRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DashboardViewModel(repository) as T
    }

}