package com.example.dashboard.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.domain.models.Note
import com.example.dashboard.screens.presentation.DashboardState
import com.example.domain.repositories.NameRepository
import com.example.domain.repositories.NotesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

internal class DashboardViewModel(
    private val notesRepository: NotesRepository,
    private val nameRepository: NameRepository
) : ViewModel() {

    private val _state = MutableStateFlow(DashboardState())
    val state = _state.asStateFlow()

    init {
        getInitialInfo()
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            notesRepository.deleteNote(note)
        }
    }

    private fun getInitialInfo() {
        val userName = nameRepository.getName()
        _state.value = _state.value.copy(
            userName = userName
        )
        notesRepository.getNotes().onEach { notesList ->
            _state.value = _state.value.copy(
                notes = notesList
            )
        }.launchIn(viewModelScope)
    }
}