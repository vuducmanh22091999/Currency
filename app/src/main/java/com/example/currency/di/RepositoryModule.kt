package com.example.currency.di

import com.example.currency.data.repository.CountryRepo
import org.koin.dsl.module

val repositoryModule = module {
    factory { CountryRepo(get()) }
}