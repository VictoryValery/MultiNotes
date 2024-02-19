package com.example.note.di

import android.content.Context
import com.example.core.di.ComponentHolder

class NoteComponent(
    val context : Context
) {

    companion object : ComponentHolder<NoteComponent>()

}