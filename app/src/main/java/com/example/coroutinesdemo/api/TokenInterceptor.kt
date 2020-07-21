package com.example.coroutinesdemo.api

import okhttp3.*

/**
 * description ： token处理拦截器
 *
 * author : taodq
 * date : 2020/3/24 10:27
 */
class TokenInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val requestBuilder = request.newBuilder()
        //添加默认的Token请求头
        requestBuilder.addHeader(
            "Authorization",
            " Basic YXBwOmFwcA=="
        )
        return chain.proceed(requestBuilder.build())
    }

}