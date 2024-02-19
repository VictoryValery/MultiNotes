package com.example.dashboard.di

import com.example.dashboard.data.DashboardRepositoryImpl
import com.example.dashboard.domain.DashboardRepository

interface DashboardDependencies {
    val repository: DashboardRepository
}

private class DashboardDependenciesImpl() : DashboardDependencies {
    override val repository: DashboardRepository = DashboardRepositoryImpl()
}