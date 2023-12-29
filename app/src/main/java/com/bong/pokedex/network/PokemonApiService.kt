package com.bong.pokedex.network

import com.bong.pokedex.data.PokemonContestEffect
import com.bong.pokedex.data.PokemonDetail
import com.bong.pokedex.data.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface PokemonApiService {
//    @GET("pokemon")
//    suspend fun getPokemonList(
//        @Query("limit") limit: Int,
//        @Query("offset") offset: Int
//    ): PokemonListResponse

    @GET("contest-effect/{id}")
    suspend fun getPokemonContestEffectById(@Path("id") id: String) : PokemonContestEffect

    @GET("pokemon/{nameOrId}")
    suspend fun getPokemonByNameOrId(@Path("nameOrId") nameOrId: String): PokemonDetail

    @GET
    suspend fun getPokemonList(@Url url: String): PokemonListResponse

    @GET("")
    suspend fun getPokemonDetail(@Url url: String): PokemonDetail
}