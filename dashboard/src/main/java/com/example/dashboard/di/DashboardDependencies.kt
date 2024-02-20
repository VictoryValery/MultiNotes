package com.example.dashboard.di

import com.example.domain.repositories.NameRepository
import com.example.domain.repositories.NotesRepository


interface DashboardDependencies {
    val notesRepository: NotesRepository
    val nameRepository: NameRepository

    companion object {
        fun init(
            notesRepository: NotesRepository,
            nameRepository: NameRepository
        ): DashboardDependencies = DashboardDependenciesImpl(
            notesRepository = notesRepository,
            nameRepository = nameRepository
        )
    }
}

private class DashboardDependenciesImpl(
    override val notesRepository: NotesRepository,
    override val nameRepository: NameRepository
) : DashboardDependencies