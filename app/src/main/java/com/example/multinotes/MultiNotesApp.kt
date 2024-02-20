package com.example.multinotes

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.dashboard.di.DashboardComponent
import com.example.dashboard.di.DashboardDependencies
import com.example.data.repository.NameRepositoryImpl
import com.example.data.repository.NotesRepositoryImpl
import com.example.data.storage.name.NameStorageImpl
import com.example.data.storage.notes.NotesDatabase
import com.example.data.storage.notes.NotesDatabase.Companion.DATABASE_NAME
import com.example.note.di.NoteComponent

class MultiNotesApp : Application() {
    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        NoteComponent.set(
            provider = { NoteComponent(this) }
        )
        DashboardComponent.set(
            provider = {
                DashboardComponent(
                    DashboardDependencies.init(
                        notesRepository = NotesRepositoryImpl(
                            provideNoteDatabase(this).noteDao,
                        ),
                        nameRepository = NameRepositoryImpl(
                            NameStorageImpl(this)
                        )
                    )
                )
            }
        )
    }

    private fun provideNoteDatabase(context: Context): NotesDatabase {
        return Room.databaseBuilder(
            context,
            NotesDatabase::class.java,
            DATABASE_NAME
        ).build()
    }


}