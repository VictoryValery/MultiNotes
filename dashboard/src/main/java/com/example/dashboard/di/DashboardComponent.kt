package com.example.dashboard.di

import com.example.core.di.ComponentHolder

class DashboardComponent(
    dashboardDependencies: DashboardDependencies
) {
    companion object : ComponentHolder<DashboardComponent>()

    internal val dashboardVmFactory = DashboardVmFactory(
        notesRepository = dashboardDependencies.notesRepository,
        nameRepository = dashboardDependencies.nameRepository
    )
}