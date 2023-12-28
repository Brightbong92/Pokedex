package com.bong.pokedex.data

data class PokemonListResponse(
    val count: Int, val next: String?, val previous: String?, val results: List<PokemonListResult>
)

data class PokemonListResult(
    val name: String, val url: String,
)

data class PokemonResult(
    val id: Int?,
    val name: String,
    val img_url: String,
)

data class PokemonDetail(
    val id: Int,
    val name: String,
    val base_experience: Int,
    val height: Int,
    val is_default: Boolean,
    val order: Int,
    val weight: Int,
    val abilities: List<Ability>,
    val forms: List<Form>,
    val game_indices: List<GameIndex>,
    val held_items: List<HeldItem>,
    val location_area_encounters: String,
    val moves: List<Move>,
    val species: Species,
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<Type>,
    val past_types: List<PastType>
)

data class Ability(
    val is_hidden: Boolean, val slot: Int, val ability: AbilityInfo
)

data class AbilityInfo(
    val name: String, val url: String
)

data class Form(
    val name: String, val url: String
)

data class GameIndex(
    val game_index: Int, val version: Version
)

data class Version(
    val name: String, val url: String
)

data class HeldItem(
    val item: Item, val version_details: List<VersionDetail>
)

data class Item(
    val name: String, val url: String
)

data class VersionDetail(
    val rarity: Int, val version: Version
)

data class Move(
    val move: MoveInfo, val version_group_details: List<VersionGroupDetail>
)

data class MoveInfo(
    val name: String, val url: String
)

data class VersionGroupDetail(
    val level_learned_at: Int, val version_group: Version
)

data class Species(
    val name: String, val url: String
)

data class Sprites(
    val back_default: String?,
    val back_female: String?,
    val back_shiny: String?,
    val back_shiny_female: String?,
    val front_default: String?,
    val front_female: String?,
    val front_shiny: String?,
    val front_shiny_female: String?,
    val other: OtherSprites,
    val versions: Map<String, Map<String, SpriteVersions>>
)

data class OtherSprites(
    val dream_world: DreamWorldSprites,
    val home: HomeSprites,
    val official_artwork: OfficialArtworkSprites,
    val showdown: ShowdownSprites
)

data class DreamWorldSprites(
    val front_default: String?, val front_female: String?
)

data class HomeSprites(
    val front_default: String?,
    val front_female: String?,
    val front_shiny: String?,
    val front_shiny_female: String?
)

data class OfficialArtworkSprites(
    val front_default: String?, val front_shiny: String?
)

data class ShowdownSprites(
    val back_default: String?,
    val back_female: String?,
    val back_shiny: String?,
    val back_shiny_female: String?,
    val front_default: String?,
    val front_female: String?,
    val front_shiny: String?,
    val front_shiny_female: String?
)

data class SpriteVersions(
    val back_default: String?,
    val back_gray: String?,
    val front_default: String?,
    val front_gray: String?
)

data class Stat(
    val base_stat: Int, val effort: Int, val stat: StatInfo
)

data class StatInfo(
    val name: String, val url: String
)

data class Type(
    val slot: Int, val type: TypeInfo
)

data class TypeInfo(
    val name: String, val url: String
)

data class PastType(
    val generation: Generation, val types: List<Type>
)

data class Generation(
    val name: String, val url: String
)