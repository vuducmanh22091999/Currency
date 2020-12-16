package com.example.currency.data.remote

import com.example.currency.data.model.country.ResultResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyServices {
    @GET("countries")
    suspend fun getCountries(@Query("apiKey") apiKey: String): Response<ResultResponse>

//    @GET("convert")
//    suspend fun getCurrency(
//        @Query("apiKey") apiKey: String,
//        @Query("q") q: String,
//        @Query("compact") compact: String
//    ) : Response<MutableMap<String, String>>
}