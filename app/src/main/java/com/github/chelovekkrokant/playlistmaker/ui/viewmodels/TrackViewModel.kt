package com.github.chelovekkrokant.playlistmaker.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.github.chelovekkrokant.playlistmaker.MyApplication
import com.github.chelovekkrokant.playlistmaker.domain.api.TrackSearchInteractor

class TrackViewModel(
    private val trackId: String,
    private val trackSearchInteractor: TrackSearchInteractor,
) : ViewModel() {

    init {
        Log.d("TEST", "init!: $trackId")
    }

    companion object {
        fun getViewModelFactory(trackId: String): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val interactor =
                    (this[ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY] as MyApplication).provideTrackSearchInteractor()

                TrackViewModel(
                    trackId,
                    interactor
                )
            }
        }
    }
}