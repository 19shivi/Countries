package com.example.countries.Networks

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val client= OkHttpClient.Builder().build()
    private  val retrofit= Retrofit.Builder()
        .baseUrl("https://restcountries.eu/rest/v2/region/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
    fun <T> buildService(service :Class<T>):T{
        return retrofit.create(service)
    }
}