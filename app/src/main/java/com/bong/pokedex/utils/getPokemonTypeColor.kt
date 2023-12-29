package com.bong.pokedex.utils

import androidx.compose.ui.graphics.Color
import com.bong.pokedex.ui.theme.GrayScaleDark
import com.bong.pokedex.ui.theme.PokemonTypeBug
import com.bong.pokedex.ui.theme.PokemonTypeDark
import com.bong.pokedex.ui.theme.PokemonTypeDragon
import com.bong.pokedex.ui.theme.PokemonTypeElectric
import com.bong.pokedex.ui.theme.PokemonTypeFairy
import com.bong.pokedex.ui.theme.PokemonTypeFighting
import com.bong.pokedex.ui.theme.PokemonTypeFire
import com.bong.pokedex.ui.theme.PokemonTypeFlying
import com.bong.pokedex.ui.theme.PokemonTypeGhost
import com.bong.pokedex.ui.theme.PokemonTypeGrass
import com.bong.pokedex.ui.theme.PokemonTypeGround
import com.bong.pokedex.ui.theme.PokemonTypeIce
import com.bong.pokedex.ui.theme.PokemonTypeNormal
import com.bong.pokedex.ui.theme.PokemonTypePoison
import com.bong.pokedex.ui.theme.PokemonTypePsychic
import com.bong.pokedex.ui.theme.PokemonTypeRock
import com.bong.pokedex.ui.theme.PokemonTypeSteel
import com.bong.pokedex.ui.theme.PokemonTypeWater

fun getPokemonTypeColor(typeName: String) : Color {
    return when (typeName.lowercase()) {
        "bug" -> PokemonTypeBug
        "dark" -> PokemonTypeDark
        "dragon" -> PokemonTypeDragon
        "electric" -> PokemonTypeElectric
        "fairy" -> PokemonTypeFairy
        "fighting" -> PokemonTypeFighting
        "fire" -> PokemonTypeFire
        "flying" -> PokemonTypeFlying
        "ghost" -> PokemonTypeGhost
        "normal" -> PokemonTypeNormal
        "ground" -> PokemonTypeGround
        "ice" -> PokemonTypeIce
        "poison" -> PokemonTypePoison
        "psychic" -> PokemonTypePsychic
        "rock" -> PokemonTypeRock
        "steel" -> PokemonTypeSteel
        "water" -> PokemonTypeWater
        "grass" -> PokemonTypeGrass
        else -> GrayScaleDark
    }


}