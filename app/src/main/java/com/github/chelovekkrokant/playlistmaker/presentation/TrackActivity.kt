package com.github.chelovekkrokant.playlistmaker.presentation

import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.github.chelovekkrokant.playlistmaker.ui.viewmodels.TrackViewModel

class TrackActivity: ComponentActivity() {
    private val viewModel by viewModels<TrackViewModel> { TrackViewModel.getViewModelFactory("123") }
}