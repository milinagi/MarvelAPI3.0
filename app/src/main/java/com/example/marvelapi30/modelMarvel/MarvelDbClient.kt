package com.example.marvelapi30.modelMarvel

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MarvelDbClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://gateway.marvel.com:443/v1/public/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val getAllCharacters = retrofit.create(MarvelDbService::class.java).MarvelCharacters("characters")
    val getAllComics = retrofit.create(MarvelDbService::class.java).MarvelComics("comics")
    val getAllSeries = retrofit.create(MarvelDbService::class.java).MarvelSeries("series")

}