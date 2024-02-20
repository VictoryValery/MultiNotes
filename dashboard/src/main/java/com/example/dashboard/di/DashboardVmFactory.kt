package com.example.dashboard.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dashboard.screens.DashboardViewModel
import com.example.domain.repositories.NameRepository
import com.example.domain.repositories.NotesRepository

class DashboardVmFactory(
    private val notesRepository: NotesRepository,
    private val nameRepository: NameRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DashboardViewModel(
            notesRepository = notesRepository,
            nameRepository = nameRepository
        ) as T
    }

}