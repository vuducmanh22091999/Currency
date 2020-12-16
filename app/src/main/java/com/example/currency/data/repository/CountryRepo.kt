package com.example.currency.data.repository

import com.example.currency.data.remote.CurrencyServices

class CountryRepo(private val currencyServices: CurrencyServices) {
    suspend fun getAllCountry(apiKey: String) = currencyServices.getCountries(apiKey)
//    suspend fun getAllCurrency(apiKey: String, q: String, compact: String) =
//        currencyServices.getCurrency(apiKey, q, compact)
}