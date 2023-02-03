package com.atulya.retrofitexample.network

import com.squareup.moshi.Json

data class Character(

    @Json(name = "name")
    val name: String,

    @Json(name="image")
    val image: String
)
