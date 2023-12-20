package com.bong.pokedex.ui.detail

import androidx.lifecycle.ViewModel

class DetailViewModel : ViewModel() {
    val stats = listOf("HP", "ATK", "DEF", "SATK", "SDEF", "SPD")


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
    suspend fun fetchDataFromApi() {
        // Perform API call to get the stats data
        // Parse the response into PokemonStatData objects and assign it to stats
        // Replace this with your actual API call and parsing logic

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