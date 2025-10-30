package com.github.chelovekkrokant.playlistmaker.ui.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SearchTextViewModel: ViewModel () {
    private var _searchText = MutableStateFlow("")

    val searchText: StateFlow<String> = _searchText.asStateFlow()

    fun updateSearchText(newSearchText: String) {
        _searchText.value = newSearchText
    }

    fun clearSearchText() {
        _searchText.value = ""
    }
}