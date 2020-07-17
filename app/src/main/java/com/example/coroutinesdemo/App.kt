package com.example.coroutinesdemo

import android.app.Application
import com.example.coroutinesdemo.common.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * @author tdq
 *
 * @date 2020/7/15.
 * @description：描述
 */
class App : Application() {


    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule)
        }

    }
}