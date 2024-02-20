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

class DashboardViewModel(
    private val notesRepository: NotesRepository,
    private val nameRepository: NameRepository
) : ViewModel() {

    private val _state = MutableStateFlow(DashboardState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            addNotes()
        }
        getInitialInfo()
    }

    private suspend fun addNotes() {
        val initial = DashboardState(
            userName = "Victory",
            notes = listOf(
                Note(
                    id = 1,
                    title = "1long title for my note",
                    content = "Long content for my note double whisky and repeat please"
                ),
                Note(
                    id = 12,
                    title = "2long title for my note",
                    content = "Long content for my note double whisky and repeat please"
                ),
                Note(
                    id = 13,
                    title = "3long title for my note",
                    content = "Long content for my note double whisky and repeat please"
                ),
                Note(
                    id = 14,
                    title = "4long title for my note",
                    content = "Long content for my note double whisky and repeat please"
                ),
                Note(
                    id = 15,
                    title = "5long title for my note",
                    content = "Long content for my note double whisky and repeat please"
                )
            )
        )
        initial.notes.forEach {
            notesRepository.insertNote(it)
        }

    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            notesRepository.deleteNote(note)
        }
    }

    private fun getInitialInfo() {
        val userName = nameRepository.getName()
        _state.value = _state.value.copy(
            userName = userName.name
        )
        notesRepository.getNotes().onEach { notesList ->
            _state.value = _state.value.copy(
                notes = notesList
            )
        }.launchIn(viewModelScope)
    }
}