package com.bong.pokedex.ui.list

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bong.pokedex.data.PokemonDetail
import com.bong.pokedex.data.PokemonListResult
import com.bong.pokedex.data.PokemonResult
import com.bong.pokedex.network.PokemonApiService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val IMG_END_POINT =
    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/";
// ex) https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png

class ListViewModel : ViewModel() {
    private var TAG: String = "로그"

    private var next = "https://pokeapi.co/api/v2/pokemon?offset=0&limit=20" // page

    private val retrofit = Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    private val pokeApiService = retrofit.create(PokemonApiService::class.java)

    var pokemonList by mutableStateOf<List<PokemonResult>>(emptyList())

    init {
        loadPokemonList() // Fetch initial Pokemon list
    }

    fun loadPokemonList() {
        viewModelScope.launch {
            try {
                val response = pokeApiService.getPokemonList(next);
                val list = setFetchList(response.results);
                pokemonList += list
                next = response.next ?: ""
            } catch (e: Exception) {
                // Handle error fetching data
                Log.d(TAG, "fetchPokemonList error: $e")
                e.printStackTrace()
            }
        }
    }

    private fun extractIdFromUrl(url: String): Int {
        try {
            val splitUrl = url.split("/");
            return splitUrl[splitUrl.size - 2].toInt();
        } catch (e: Exception) {
            Log.d(TAG, "extractIdFromUrl error: $e")
        }
        return -1;
    }

    private suspend fun setFetchList(results: List<PokemonListResult>): List<PokemonResult> {
        val list = mutableListOf<PokemonResult>();
        results.forEach { pokemonListResult ->
            list.add(
                PokemonResult(
                    id = extractIdFromUrl(pokemonListResult.url) ?: 0,
                    img_url = IMG_END_POINT + extractIdFromUrl(pokemonListResult.url) + ".png",
                    name = pokemonListResult.name,
                )
            )
        }
        return list;
    }


    private fun fetchPokemonListDetail() {
        viewModelScope.launch {
            try {
                val pokemonDetails = mutableListOf<PokemonDetail>()
            } catch (e: Exception) {
                Log.d(TAG, "fetchPokemonListDetail Error: $e")
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
