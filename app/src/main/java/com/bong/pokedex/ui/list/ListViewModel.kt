package com.bong.pokedex.ui.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ListViewModel : ViewModel() {
    var isSortCardOpen by mutableStateOf(false)
        private set

    var selectedOption by mutableStateOf("")
        private set

    fun onSortCardOpen() {
        isSortCardOpen = true
    }

    fun onSortCardClose() {
        isSortCardOpen = false
    }

    fun onSortCardSelected(option: String) {
        selectedOption = option
        isSortCardOpen = false
    }
}