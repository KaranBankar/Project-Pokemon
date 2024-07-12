package com.example.pokemonusingkotli.Model

data class data(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)