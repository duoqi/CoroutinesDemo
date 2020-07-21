package com.example.coroutinesdemo.api

import okhttp3.OkHttpClient

object WanRetrofitClient : BaseRetrofitClient() {

    val service by lazy { getService(WanService::class.java, WanService.BASE_URL) }

    override fun handleBuilder(builder: OkHttpClient.Builder) {
        builder.addInterceptor(TokenInterceptor())
    }
}