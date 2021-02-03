package com.example.countries.Networks

import com.example.countries.Model.Country
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @Headers("Content-Type: application/json")
    @GET("asia")
    fun getAllCountry( ):Call<List<Country>>

}