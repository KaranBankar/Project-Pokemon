package com.example.pokemonusingkotli.Api
import android.telecom.Call
import androidx.constraintlayout.motion.widget.Key
import com.example.pokemonusingkotli.Model.Result
import com.example.pokemonusingkotli.Model.data
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("pokemon")

    fun pokemonName(@Query("limit") limit: String): retrofit2.Call<data>
}