package com.example.note.di

import com.example.core.di.ComponentHolder
import com.example.note.navigation.NoteNavigation

class NoteComponent(
    noteDependencies: NoteDependencies,
    val noteNavigation: NoteNavigation
) {
    companion object : ComponentHolder<NoteComponent>()

    internal val noteVmFactory = NoteVmFactory(noteDependencies.notesRepository)

}