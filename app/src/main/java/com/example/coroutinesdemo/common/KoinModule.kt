package com.example.coroutinesdemo.common

import com.example.coroutinesdemo.model.repository.LoginRepository
import com.example.coroutinesdemo.ui.home.HomeViewModel
import com.example.coroutinesdemo.ui.navigation.Blank2ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { Blank2ViewModel() }
}

val repositoryModule = module {
    single { LoginRepository() }
//    single { SquareRepository() }
//    single { HomeRepository() }
//    single { ProjectRepository() }
//    single { CollectRepository() }
//    single { SystemRepository() }
//    single { NavigationRepository() }
//    single { SearchRepository() }
//    single { ShareRepository() }
}

val appModule = listOf(
    viewModelModule,
    repositoryModule
)