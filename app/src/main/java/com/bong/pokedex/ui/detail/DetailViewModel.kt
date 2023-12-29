package com.bong.pokedex.ui.detail

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bong.pokedex.AmbientNavController
import com.bong.pokedex.data.PokemonContestEffect
import com.bong.pokedex.data.PokemonDetail
import com.bong.pokedex.network.PokemonApiService
import com.bong.pokedex.ui.list.PokemonDetailInfo
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class DetailViewModel : ViewModel() {
    var TAG: String = "로그"
    private val retrofit = Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create()).build()
    private val pokeApiService = retrofit.create(PokemonApiService::class.java)
    var pokemonData by mutableStateOf<PokemonDetail?>(null)
    var pokemonContestEffect by mutableStateOf<PokemonContestEffect?>(null)

    fun toUpperCaseStatName(name: String): String {
        return when (name) {
            "hp" -> "HP"
            "attack" -> "ATK"
            "defense" -> "DEF"
            "special-attack" -> "SATK"
            "special-defense" -> "SDEF"
            "speed" -> "SPD"
            else -> "No match found"
        }
    }

    suspend fun loadPokemon(nameOrId: String, id: Int) {
        viewModelScope.launch {
            try {
                var data = pokeApiService.getPokemonByNameOrId(nameOrId)
//                var contestEffectData = pokeApiService.getPokemonContestEffectById(id.toString())
                pokemonData = data
//                pokemonContestEffect = contestEffectData
            } catch (e: Exception) {
                Log.d(TAG, "loadPokemon error nameOrId: $nameOrId, id: $id")
                Log.d(TAG, "loadPokemon Error: $e")
            }
        }
    }

//    suspend fun loadPokemonContestEffect(id: String) {
//        viewModelScope.launch {
//            var data = pokeApiService.getPokemonContestEffectById(id)
//            pokemonContestEffect = data
//            Log.d(TAG, "loadPokemonContestEffect: $pokemonContestEffect")
//        }
//    }

}