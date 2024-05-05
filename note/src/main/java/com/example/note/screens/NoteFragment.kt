package com.example.note.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.note.di.NoteComponent
import com.example.note.navigation.NoteNavigation
import kotlinx.coroutines.launch

class NoteFragment : Fragment() {

    private val viewModel: NoteViewModel by viewModels { NoteComponent.get().noteVmFactory }
    private val noteNavigation: NoteNavigation = NoteComponent.get().noteNavigation

    companion object {
        private const val NOTE_ID = "NOTE_ID"
        fun newInstance(id: Int = 0): NoteFragment {
            return NoteFragment().apply {
                arguments = Bundle().apply {
                    putInt(NOTE_ID, id)
                }
            }
        }
    }

    private val noteId: Int
        get() = requireArguments().getInt(NOTE_ID)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (noteId != 0) {
            lifecycleScope.launch {
                viewModel.loadNote(noteId)
            }
        }
        (view as ComposeView).setContent {
            val state by viewModel.state.collectAsState()
            NoteScreen(
                state = state,
                viewModel = viewModel,
                navigateBack = { noteNavigation.back(this) }
            )
        }
    }
}