package com.example.note.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.note.screens.NoteState

@Composable
internal fun Note(
    state: NoteState,
    changeTitle: (String) -> Unit,
    changeContent: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val focusRequesterTitle = remember { FocusRequester() }
    val focusRequesterContent = remember { FocusRequester() }
    LaunchedEffect(Unit) {
        focusRequesterTitle.requestFocus()
    }
    Box(
        modifier = modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxSize()
        ) {
            TextField(
                text = state.title,
                onValueChange = {
                    changeTitle(it)
                },
                textStyle = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .focusRequester(focusRequesterTitle)
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                text = state.content,
                modifier = Modifier
                    .clickable(
                        indication = null,
                        enabled = true,
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = { focusRequesterContent.requestFocus() },
                    )
                    .fillMaxSize()
                    .focusRequester(focusRequesterContent)
                    .padding(bottom = 40.dp),
                onValueChange = {
                    changeContent(it)
                },
                textStyle = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview
@Composable
fun NotePreview() {
    val noteState = remember { NoteState(title = "Sample Title", content = "Sample Content") }
    val modifier = Modifier.fillMaxSize()
    Note(
        state = noteState,
        changeTitle = {},
        changeContent = {},
        modifier = modifier
    )
}