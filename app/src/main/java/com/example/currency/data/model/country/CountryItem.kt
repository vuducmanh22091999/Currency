package com.example.currency.data.model.country

import com.google.gson.annotations.SerializedName

data class CountryItem(
    @SerializedName("alpha3") val alpha3: String,
    @SerializedName("currencyId") val currencyId: String,
    @SerializedName("currencyName") val currencyName: String,
    @SerializedName("currencySymbol") val currencySymbol: String,
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String
)
