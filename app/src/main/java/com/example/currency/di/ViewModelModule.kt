package com.example.currency.di

import com.example.currency.ui.change.fragment.SwitchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SwitchViewModel(get()) }
}

