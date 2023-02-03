package com.atulya.retrofitexample.models

import com.squareup.moshi.Json

data class PersonResult(
    @Json(name = "results")
    val people: List<Person>
)
