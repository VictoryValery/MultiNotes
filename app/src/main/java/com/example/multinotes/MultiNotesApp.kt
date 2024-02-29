package com.example.multinotes

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.auth.di.AuthComponent
import com.example.auth.di.AuthDependencies
import com.example.dashboard.di.DashboardComponent
import com.example.dashboard.di.DashboardDependencies
import com.example.data.repository.NameRepositoryImpl
import com.example.data.repository.NotesRepositoryImpl
import com.example.data.storage.name.NameStorageImpl
import com.example.data.storage.notes.NotesDatabase
import com.example.data.storage.notes.NotesDatabase.Companion.DATABASE_NAME
import com.example.multinotes.navigation.AuthNavigationImpl
import com.example.multinotes.navigation.DashboardNavigationImpl
import com.example.multinotes.navigation.NoteNavigationImpl
import com.example.note.di.NoteComponent
import com.example.note.di.NoteDependencies

class MultiNotesApp : Application() {
    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        val notesRepository = NotesRepositoryImpl(
            provideNoteDatabase(this).noteDao,
        )
        val nameRepository = NameRepositoryImpl(
            NameStorageImpl(this)
        )
        AuthComponent.set(
            provider = {
                AuthComponent(
                    authDependencies = AuthDependencies.init(
                        nameRepository = nameRepository
                    ),
                    authNavigation = AuthNavigationImpl()
                )
            }
        )
        DashboardComponent.set(
            provider = {
                DashboardComponent(
                    dashboardDependencies = DashboardDependencies.init(
                        notesRepository = notesRepository,
                        nameRepository = nameRepository
                    ),
                    dashboardNavigation = DashboardNavigationImpl()
                )
            }
        )
        NoteComponent.set(
            provider = {
                NoteComponent(
                    noteDependencies = NoteDependencies.init(
                        notesRepository = notesRepository
                    ),
                    noteNavigation = NoteNavigationImpl()
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