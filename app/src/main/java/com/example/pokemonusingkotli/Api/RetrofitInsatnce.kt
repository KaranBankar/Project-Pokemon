package com.example.pokemonusingkotli.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInsatnce {

    companion object{

        private val retrofit by lazy {

            Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val api by lazy {
                retrofit.create(ApiInterface::class.java)
        }
    }
}