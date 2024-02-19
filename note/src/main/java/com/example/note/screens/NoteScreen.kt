package com.example.note.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.note.di.NoteComponent

@Composable
fun NoteScreen(){
    NoteComponent.get().context
    Text(text = "Hello NoteScreen!")

}