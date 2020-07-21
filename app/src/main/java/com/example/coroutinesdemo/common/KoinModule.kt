package com.example.coroutinesdemo.common

import com.example.coroutinesdemo.data.repository.Blank3Repository
import com.example.coroutinesdemo.data.repository.LoginRepository
import com.example.coroutinesdemo.ui.home.HomeViewModel
import com.example.coroutinesdemo.ui.navigation.Blank2ViewModel
import com.example.coroutinesdemo.ui.navigation.Blank3ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { Blank2ViewModel() }
    viewModel { Blank3ViewModel(get()) }
}

val repositoryModule = module {
    single { LoginRepository() }
    single { Blank3Repository() }
}

val appModule = listOf(
    viewModelModule,
    repositoryModule
)