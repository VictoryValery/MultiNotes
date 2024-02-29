package com.example.multinotes.navigation

import androidx.fragment.app.Fragment
import com.example.auth.navigation.AuthNavigation
import com.example.dashboard.screens.DashboardFragment
import com.example.multinotes.R

class AuthNavigationImpl: AuthNavigation {
    override fun dashboard(fragment: Fragment) {
        fragment.parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, DashboardFragment.newInstance())
            .commit()
    }
}