package com.bong.pokedex.network

import com.bong.pokedex.data.PokemonDetail
import com.bong.pokedex.data.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface PokemonApiService {
//    @GET("pokemon")
//    suspend fun getPokemonList(
//        @Query("limit") limit: Int,
//        @Query("offset") offset: Int
//    ): PokemonListResponse

    @GET
    suspend fun getPokemonList(@Url url:String): PokemonListResponse

    @GET
    suspend fun getPokemonDetail(@Url url:String): PokemonDetail
}