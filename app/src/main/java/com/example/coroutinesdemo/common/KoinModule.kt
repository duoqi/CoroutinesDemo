package com.example.coroutinesdemo.common

import com.example.coroutinesdemo.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel() }
}

val repositoryModule = module {
//    single { WanRetrofitClient.getService(WanService::class.java, WanService.BASE_URL) }
//    single { CoroutinesDispatcherProvider() }
//    single { LoginRepository(get()) }
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