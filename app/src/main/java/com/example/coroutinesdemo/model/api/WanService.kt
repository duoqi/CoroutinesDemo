package com.example.coroutinesdemo.model.api

import com.example.coroutinesdemo.model.bean.User
import retrofit2.http.*

interface WanService {

    companion object {
        const val BASE_URL = "http://125.76.225.162:80/api/"
    }

    /***
     * 登录接口
     */
    @FormUrlEncoded
    @POST("auth/oauth/token")
    suspend fun login(@FieldMap map: Map<String, String?>): User?

}