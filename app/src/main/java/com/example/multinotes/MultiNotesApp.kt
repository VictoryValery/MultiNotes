package com.example.multinotes

import android.app.Application
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
    }


}