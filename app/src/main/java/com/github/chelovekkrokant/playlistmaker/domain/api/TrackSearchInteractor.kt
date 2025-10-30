package com.github.chelovekkrokant.playlistmaker.domain.api

import com.github.chelovekkrokant.playlistmaker.domain.models.Track

interface TrackSearchInteractor {
    fun searchTracks(expression: String): List<Track>
}