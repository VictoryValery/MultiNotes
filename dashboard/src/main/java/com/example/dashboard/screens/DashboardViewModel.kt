package com.example.dashboard.screens

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.domain.Note
import com.example.dashboard.domain.DashboardRepository
import com.example.dashboard.screens.presentation.DashboardState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class DashboardViewModel(
    private val repository: DashboardRepository
) : ViewModel() {

    private val _state = mutableStateOf(DashboardState())
    val state: State<DashboardState> = _state

    init {
        getInitialInfo()
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            repository.deleteNote(note)
        }
    }

    private fun getInitialInfo() {
        repository.getDashboardInfo().onEach { notesList ->
            _state.value = _state.value.copy(
                notes = notesList
            )
        }.launchIn(viewModelScope)
    }
}