package com.example.currency.ui.change.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currency.data.model.country.CountryItem
import com.example.currency.data.repository.CountryRepo
import kotlinx.coroutines.launch

class SwitchViewModel(private val countryRepo: CountryRepo) : ViewModel() {
    var country: MutableLiveData<MutableList<CountryItem>> = MutableLiveData()
    var currency: MutableLiveData<MutableList<String>> = MutableLiveData()

    fun getCountry(apiKey: String) {
        viewModelScope.launch {
            val response = countryRepo.getAllCountry(apiKey).body()
            if (response != null) {
                val results: MutableMap<String, CountryItem> = response.results
                val countryItems: MutableList<CountryItem> = results.values.toMutableList()
                country.value = countryItems
            }
        }
    }

//    fun getCurrency(apiKey: String, q: String, compact: String) {
//        viewModelScope.launch {
//            val response = countryRepo.getAllCurrency(apiKey, q, "ultra").body()
//            if (response != null) {
//
//            }
//        }
//    }
}