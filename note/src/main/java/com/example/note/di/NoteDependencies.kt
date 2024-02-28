package com.example.note.di

import com.example.domain.repositories.NotesRepository

interface NoteDependencies {
    val notesRepository: NotesRepository

    companion object {
        fun init(
            notesRepository: NotesRepository
        ): NoteDependencies = NoteDependenciesImpl(notesRepository)
    }
}

private class NoteDependenciesImpl(
    override val notesRepository: NotesRepository
) : NoteDependencies