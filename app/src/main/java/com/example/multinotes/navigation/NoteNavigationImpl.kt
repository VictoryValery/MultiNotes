package com.example.multinotes.navigation

import androidx.fragment.app.Fragment
import com.example.note.navigation.NoteNavigation

class NoteNavigationImpl : NoteNavigation {
    override fun back(fragment: Fragment) {
        fragment.parentFragmentManager.popBackStack()
    }

}