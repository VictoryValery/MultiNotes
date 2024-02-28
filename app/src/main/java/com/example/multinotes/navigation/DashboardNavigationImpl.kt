package com.example.multinotes.navigation

import androidx.fragment.app.Fragment
import com.example.dashboard.navigation.DashboardNavigation
import com.example.multinotes.R
import com.example.note.screens.NoteFragment

class DashboardNavigationImpl : DashboardNavigation {
    override fun newNoteScreen(fragment: Fragment) {
        fragment.parentFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, NoteFragment.newInstance())
            .addToBackStack("Note")
            .commit()
    }

    override fun existingNoteScreen(fragment: Fragment, id: Int) {
        fragment.parentFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, NoteFragment.newInstance(id))
            .addToBackStack("ExistingNote")
            .commit()
    }

    override fun back(fragment: Fragment) {
        fragment.requireActivity().finish()
    }

}