package com.example.coroutinesdemo

import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.coroutinesdemo.base.BaseVMActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : BaseVMActivity(useDataBinding = false) {

    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun initView() {
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)
    }

    override fun startObserve() {
    }
}