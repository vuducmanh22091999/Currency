package com.example.currency.data.model.country

import com.squareup.moshi.Json

data class ResultResponse(@field:Json(name="results") val results: MutableMap<String, CountryItem>)