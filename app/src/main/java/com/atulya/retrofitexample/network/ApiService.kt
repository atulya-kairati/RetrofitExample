package com.atulya.retrofitexample.network

import com.atulya.retrofitexample.models.PersonResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("character")
    fun fetchCharacter(@Query(value = "page") page: String): Call<PersonResult>
}