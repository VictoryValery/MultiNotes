package com.example.dashboard.screens.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.common_ui.domain.ui_models.UiNote
import com.example.dashboard.screens.presentation.DashboardState

private const val EMPTY_DASHBOARD = "Нет заметок"

@Composable
internal fun DashboardContent(
    state: DashboardState,
    onDelete: (UiNote) -> Unit,
    existingNote: (id: Int) -> Unit,
    paddingValues: PaddingValues,
) {
    if (state.notes.isEmpty()) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = EMPTY_DASHBOARD,
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxSize(),
            contentPadding = paddingValues,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(state.notes) { note ->
                NoteItem(
                    note = note,
                    onDeleteClick = { onDelete(note) },
                    onNoteClick = { existingNote.invoke(note.id ?: 0) }
                )
                if (state.notes.last().id == note.id)
                    Spacer(modifier = Modifier.height(72.dp))
            }
        }
    }
}

@Preview
@Composable
fun DashboardContentPreview() {
    val noteList = listOf(
        UiNote(id = 1, title = "Note 1", content = "Content 1"),
        UiNote(id = 2, title = "Note 2", content = "Content 2"),
        UiNote(id = 3, title = "Note 3", content = "Content 3")
    )
    val dashboardState = remember {
        DashboardState(
            userName = "userName",
            notes = noteList
        )
    }
    val padding = PaddingValues(16.dp)
    DashboardContent(
        state = dashboardState,
        onDelete = {},
        existingNote = {},
        paddingValues = padding
    )
}