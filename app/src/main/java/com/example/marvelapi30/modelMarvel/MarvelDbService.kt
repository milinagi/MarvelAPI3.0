package com.example.marvelapi30.modelMarvel

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelDbService {

    @GET("characters")
    fun MarvelCharacters(@Query("api_Key") apiKey: String): Call<MarvelDbResult>

    @GET("comics")
    fun MarvelComics(@Query("api_Key") apiKey: String): Call<MarvelDbResult>

    @GET("series")
    fun MarvelSeries(@Query("api_Key") apiKey: String): Call<MarvelDbResult>
}