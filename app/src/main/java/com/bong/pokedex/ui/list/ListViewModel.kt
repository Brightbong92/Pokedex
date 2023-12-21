package com.bong.pokedex.ui.list

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bong.pokedex.network.PokemonApiService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListViewModel : ViewModel() {
    var TAG: String = "로그"

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val pokeApiService = retrofit.create(PokemonApiService::class.java)

    var pokemonList by mutableStateOf<List<Pokemon>>(emptyList())
        private set

    init {
        // Fetch initial Pokemon list
        Log.d(TAG, "init 실행 ")
        fetchPokemonList()
    }

    private fun fetchPokemonList() {
        viewModelScope.launch {
            try {
                Log.d(TAG, "fetchPokemonList run")
                val response = pokeApiService.getPokemonList(limit = 20, offset = 0)
                Log.d(TAG, "fetchPokemonList: ${response.results}")
            } catch (e: Exception) {
                // Handle error fetching data
                Log.d(TAG, "fetchPokemonList catch: $e")
                e.printStackTrace()
            }
        }
    }


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