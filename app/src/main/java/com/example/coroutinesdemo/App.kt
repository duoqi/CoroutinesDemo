package com.example.coroutinesdemo

import android.app.Application
import com.example.coroutinesdemo.data.db.AppDatabase
import com.example.coroutinesdemo.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

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
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            androidFileProperties()
            modules(appModule)
        }
    }
}