package com.example.currency.di

import com.example.currency.data.remote.CurrencyServices
import com.example.currency.utils.BASE
import com.example.currency.utils.BASE_URL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single { providerGson() }
    single { providerHttp() }
    single { providerRetrofit(get(), get()) }
    single { providerApp(get()) }
}

fun providerGson(): Gson = GsonBuilder().create()

fun providerRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson)).build()

fun providerHttp(): OkHttpClient {
    val okHttpBuilder = OkHttpClient.Builder()
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY
    okHttpBuilder.addInterceptor(logging)
    return okHttpBuilder.build()
}

fun providerApp(retrofit: Retrofit): CurrencyServices =
    retrofit.create(CurrencyServices::class.java)