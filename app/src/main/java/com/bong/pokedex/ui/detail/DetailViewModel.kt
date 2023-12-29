package com.bong.pokedex.ui.detail

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.bong.pokedex.data.PokemonDetail
import com.bong.pokedex.network.PokemonApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class DetailViewModel : ViewModel() {
    var TAG: String = "로그"
    private val retrofit = Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create()).build()
    private val pokeApiService = retrofit.create(PokemonApiService::class.java)

    var pokemonData by mutableStateOf<PokemonDetail?>(null)


    // List to hold the API response dummy data
    var apiStats: List<PokemonStatData> = listOf(
        PokemonStatData(
            base_stat = 45,
            effort = 0,
            stat = StatDetail("hp", "https://pokeapi.co/api/v2/stat/1/")
        ),
        PokemonStatData(
            base_stat = 49,
            effort = 0,
            stat = StatDetail("attack", "https://pokeapi.co/api/v2/stat/2/")
        ),
        PokemonStatData(
            base_stat = 49,
            effort = 0,
            stat = StatDetail("defense", "https://pokeapi.co/api/v2/stat/3/")
        ),
        PokemonStatData(
            base_stat = 65,
            effort = 1,
            stat = StatDetail("special-attack", "https://pokeapi.co/api/v2/stat/4/")
        ),
        PokemonStatData(
            base_stat = 65,
            effort = 0,
            stat = StatDetail("special-defense", "https://pokeapi.co/api/v2/stat/5/")
        ),
        PokemonStatData(
            base_stat = 45,
            effort = 0,
            stat = StatDetail("speed", "https://pokeapi.co/api/v2/stat/6/")
        )
    )

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

    // Function to fetch data from the API and update the stats
    suspend fun loadPokemon(nameOrId: String) {
        // Perform API call to get the stats data
        // Parse the response into PokemonStatData objects and assign it to stats
        // Replace this with your actual API call and parsing logic
        var data = pokeApiService.getPokemonByNameOrId(nameOrId)
        pokemonData = data
        Log.d(TAG, "loadPokemon: $pokemonData")
    }

}

data class PokemonStatData(
    val base_stat: Int,
    val effort: Int,
    val stat: StatDetail
)

data class StatDetail(
    val name: String,
    val url: String
)