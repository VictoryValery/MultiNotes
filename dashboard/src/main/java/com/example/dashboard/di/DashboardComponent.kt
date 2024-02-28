package com.example.dashboard.di

import com.example.core.di.ComponentHolder
import com.example.dashboard.navigation.DashboardNavigation

class DashboardComponent(
    dashboardDependencies: DashboardDependencies,
    val dashboardNavigation: DashboardNavigation
) {
    companion object : ComponentHolder<DashboardComponent>()

    internal val dashboardVmFactory = DashboardVmFactory(
        notesRepository = dashboardDependencies.notesRepository,
        nameRepository = dashboardDependencies.nameRepository
    )
}