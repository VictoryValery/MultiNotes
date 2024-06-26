package com.example.note.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.common_ui.domain.ui_models.UiNote
import com.example.domain.repositories.NotesRepository
import com.example.note.screens.components.Note
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

private const val TITLE_ERROR = "Заголовок уже существует. Пожалуйста, введите другой"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun NoteScreen(
    state: NoteState,
    viewModel: NoteViewModel,
    navigateBack: () -> Unit,
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val context = LocalContext.current
    var showToast by remember { mutableStateOf(false) }
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navigateBack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        },
        content = { innerPadding ->
            Note(
                state = state,
                changeTitle = { viewModel.changeTitle(it) },
                changeContent = { viewModel.changeContent(it) },
                modifier = Modifier
                    .padding(innerPadding)
            )
        },
        floatingActionButton = {
            IconButton(
                onClick = {
                    viewModel.saveNote()
                    showToast = !showToast
                },
            ) {
                Icon(
                    imageVector = Icons.Default.Done,
                    contentDescription = "Save note",
                    tint = Color.Black
                )
            }
        }
    )
    if (state.titleIsUnique == false) {
        LaunchedEffect(showToast) {
            android.widget.Toast.makeText(context, TITLE_ERROR, android.widget.Toast.LENGTH_SHORT)
                .show()
            delay(2000)
        }
    } else {
        state.titleIsUnique?.let { navigateBack() }
    }
}

@Preview
@Composable
fun NoteScreenPreview() {
    val noteState = remember { NoteState(title = "Sample Title", content = "Sample Content") }
    val notesRepository = object : NotesRepository {
        override fun getNotes(): Flow<List<UiNote>> {
            return flowOf(emptyList())
        }

        override suspend fun getNoteById(id: Int): UiNote? {
            return null
        }

        override suspend fun insertNote(note: UiNote): Boolean {
            return true
        }

        override suspend fun deleteNote(note: UiNote) {}
    }

    val noteViewModel = remember { NoteViewModel(notesRepository) }
    NoteScreen(
        state = noteState,
        viewModel = noteViewModel,
        navigateBack = {}
    )
}