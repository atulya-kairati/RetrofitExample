package com.atulya.retrofitexample.repository

import com.atulya.retrofitexample.network.ApiService
import com.atulya.retrofitexample.models.Person
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.await
import retrofit2.converter.moshi.MoshiConverterFactory

const val BASE_URL = "https://rickandmortyapi.com/api/"

class Repository private constructor(){

    // Moshi is used to parse json
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    private val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    suspend fun fetchPeople(): List<Person> = apiService.fetchCharacter("1").await().people

    companion object {
        private var INSTANCE: Repository? = null

        fun init () {
            if (INSTANCE == null){
                INSTANCE = Repository()
            }
        }

        fun get() = checkNotNull(INSTANCE){
            "Error: Initialise the repository first!"
        }
    }
}