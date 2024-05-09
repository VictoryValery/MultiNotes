package com.example.dashboard.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.common_ui.domain.ui_models.UiNote
import com.example.dashboard.screens.presentation.DashboardState
import com.example.dashboard.screens.ui.NoteItem

private const val EMPTY_DASHBOARD = "Нет заметок"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun DashboardScreen(
    state: DashboardState,
    onDelete: (UiNote) -> Unit,
    newNote: () -> Unit,
    existingNote: (id: Int) -> Unit,
    navigateBack: () -> Unit,
) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    Scaffold(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            MediumTopAppBar(
                title = {
                    state.userName?.let {
                        Text(
                            text = it,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { navigateBack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Leave app"
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier
                    .size(48.dp),
                onClick = { newNote() },
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add new note"
                )
            }
        },
    ) {
        if (state.notes.isEmpty()) {
            Column(
                modifier = Modifier
                    .padding(it)
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
                    .fillMaxSize(),
                contentPadding = it,
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
}