package com.example.note.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common_ui.domain.ui_models.UiNote
import com.example.domain.repositories.NotesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class NoteViewModel(
    private val notesRepository: NotesRepository
) : ViewModel() {

    private val _state = MutableStateFlow(NoteState())
    val state = _state.asStateFlow()

    suspend fun loadNote(id: Int) {
        if (id == 0)
            return
        val note = notesRepository.getNoteById(id)
        note?.let {
            _state.value = _state.value.copy(
                id = note.id,
                content = note.content,
                title = note.title
            )
        }
    }

    fun changeTitle(title: String) {
        _state.value = state.value.copy(
            title = title,
        )
    }

    fun changeContent(content: String) {
        _state.value = state.value.copy(
            content = content,
        )
    }

    fun saveNote() {
        _state.value = _state.value.copy(titleIsUnique = null)
        viewModelScope.launch {
            runCatching {
                notesRepository.insertNote(
                    UiNote(
                        id = state.value.id,
                        title = state.value.title,
                        content = state.value.content
                    )
                )
            }.fold(
                onSuccess = {
                    _state.value = _state.value.copy(titleIsUnique = it)
                },
                onFailure = {
                    _state.value = _state.value.copy(titleIsUnique = false)
                }
            )
        }
    }
}
