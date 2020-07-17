package com.example.coroutinesdemo.model.repository

import com.example.coroutinesdemo.base.BaseRepository
import com.example.coroutinesdemo.model.api.WanRetrofitClient
import com.example.coroutinesdemo.model.bean.HttpResult
import com.example.coroutinesdemo.model.bean.User
import com.example.coroutinesdemo.util.MD5Util

/**
 * @author tdq
 *
 * @date 2020/7/17.
 * @description：描述
 */
class LoginRepository : BaseRepository() {

    suspend fun login(username: String, password: String): HttpResult<User> {
        return safeApiCall(call = { requestLogin(username, password) }, errorMessage = "")
    }

    private suspend fun requestLogin(username: String, password: String): HttpResult<User> {
        val map = HashMap<String, String?>()
        map["username"] = username
        map["password"] = MD5Util.encode(password)
        map["grant_type"] = "password"
        val response = WanRetrofitClient.service.login(map)
        return executeResponse(response)
    }
}