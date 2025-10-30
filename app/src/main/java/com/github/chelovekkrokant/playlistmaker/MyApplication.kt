package com.github.chelovekkrokant.playlistmaker

import android.app.Application
import com.github.chelovekkrokant.playlistmaker.data.TrackRepositoryImpl
import com.github.chelovekkrokant.playlistmaker.data.network.RetrofitNetworkClient
import com.github.chelovekkrokant.playlistmaker.domain.api.TrackRepository
import com.github.chelovekkrokant.playlistmaker.domain.api.TrackSearchInteractor
import com.github.chelovekkrokant.playlistmaker.domain.impl.TrackSearchInteractorImpl

class MyApplication: Application() {
    fun getRepository(): TrackRepository {
        return TrackRepositoryImpl(RetrofitNetworkClient())
    }

    fun provideTrackSearchInteractor(): TrackSearchInteractor {
        return TrackSearchInteractorImpl(getRepository())
    }

}