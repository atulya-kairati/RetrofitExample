package com.atulya.retrofitexample.models

import com.squareup.moshi.Json

data class Person(

    @Json(name = "name")
    val name: String,

    @Json(name="image")
    val image: String
)
