package com.example.dashboard.navigation

import androidx.fragment.app.Fragment

interface DashboardNavigation {
    fun newNoteScreen(fragment: Fragment)
    fun existingNoteScreen(fragment: Fragment, id: Int)
    fun back(fragment: Fragment)
}