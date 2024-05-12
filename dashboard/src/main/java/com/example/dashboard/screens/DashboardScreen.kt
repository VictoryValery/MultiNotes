package com.example.dashboard.screens

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.common_ui.domain.ui_models.UiNote
import com.example.dashboard.screens.presentation.DashboardState
import com.example.dashboard.screens.ui.DashboardContent

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
        DashboardContent(
            state = state,
            onDelete = onDelete,
            existingNote = existingNote,
            paddingValues = it
        )
    }
}

@Preview
@Composable
fun DashboardScreenPreview() {
    val dashboardState = remember { DashboardState(userName = "John Doe") }
    DashboardScreen(
        state = dashboardState,
        onDelete = {},
        newNote = {},
        existingNote = {},
        navigateBack = {}
    )
}