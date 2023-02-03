package com.atulya.retrofitexample.network

import com.squareup.moshi.Json

data class PersonResult(
    @Json(name = "results")
    val result: List<Person>
)
